package ru.geekbrains.lesson11.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Repository<T> {

    private static final Map<Class<?>, String> typesMap = Map.of(
            Integer.class, "INT",
            Long.class, "BIGINT",
            String.class, "VARCHAR(1024)"
    );

    private final Class<T> repositoryClass;

    private final Connection connection;

    private final String tableName;

    private final List<ColumnInfo> columns;

    private final PreparedStatement selectByIdStatement;

    private final PreparedStatement insertStatement;

    private final PreparedStatement selectAllStatement;

    private final PreparedStatement deleteStatement;

    private final PreparedStatement updateStatement;

    public Repository(Class<T> repositoryClass, Connection connection) throws SQLException {
        this.repositoryClass = repositoryClass;
        this.connection = connection;

        DbTable dbTable = repositoryClass.getAnnotation(DbTable.class);
        if (dbTable == null) {
            throw new IllegalStateException("No dbTable annotation");
        }
        this.tableName = dbTable.tableName();

        DbId dbId = null;
        int count = 0;
        this.columns = new ArrayList<>();
        for (Field field : repositoryClass.getDeclaredFields()) {
            field.setAccessible(true);
            dbId = field.getAnnotation(DbId.class);
            if (dbId != null) {
                ColumnInfo columnInfo = new ColumnInfo(field.getName(), field.getName(), field.getType(), true);
                columns.add(columnInfo);
                count++;
                continue;
            }
            DbColumn dbColumn = field.getAnnotation(DbColumn.class);
            if (dbColumn != null) {
                ColumnInfo columnInfo = new ColumnInfo(field.getName(), dbColumn.columnName(), field.getType(), false);
                columns.add(columnInfo);
            }
            // TODO проверить, чтобы поле с аннотацией @DbId было только одно. Если их больше, то выдать сообщение об ошибке
            if (count == 0) {
                throw new IllegalStateException("Field DbId not found");
            } else if (count > 1) {
                // TODO если поле с аннотацией @DbId не найдено, то выдать сообщение об ошибке
                throw new IllegalStateException("Field DbId more than one");
            }
        }


        createTableIfNotExists();

        this.selectByIdStatement = buildSelectByIdStatement();
        this.insertStatement = buildInsertStatement();
        this.selectAllStatement = buildFindAllStatement();
        this.updateStatement = buildUpdateStatement();
        this.deleteStatement = buildDeleteStatement();
    }

    public List<T> findAll() throws SQLException {
        LinkedList<T> list = new LinkedList<>();

        ResultSet rs = selectAllStatement.executeQuery();

        while (rs.next()) {
            list.add(createEntityByResultSet(rs));
        }

        return list;
    }

    public T findById(Long id) throws SQLException {
        selectByIdStatement.setLong(1, id);
        ResultSet rs = selectByIdStatement.executeQuery();
        T result = null;
        while (rs.next()) {
            if (result != null) {
                throw new IllegalStateException("More then one record for primary key value " + id);
            }
            result = createEntityByResultSet(rs);
        }
        return result;
    }

    public void insert(T entity) throws SQLException {
        for (int i = 1; i < columns.size(); i++) {
            insertStatement.setObject(i, invokeGetter(columns.get(i).fieldName, entity));
        }
        insertStatement.execute();
    }

    public void update(T entity) throws SQLException {
        int count = 0;
        for (int i = 0; i < columns.size(); i++) {
            if (!columns.get(i).isId) {
                updateStatement.setObject(i - count + 1, invokeGetter(columns.get(i).fieldName, entity));
            } else {
                count++;
                updateStatement.setObject(columns.size(), invokeGetter(columns.get(i).fieldName, entity));
            }
        }
        updateStatement.execute();
    }

    public void delete(Long id) throws SQLException {
        deleteStatement.setLong(1, id);
        deleteStatement.execute();
    }

    private T createEntityByResultSet(ResultSet rs) throws SQLException {
        T entity = newInstance();
        for (ColumnInfo columnInfo : columns) {
            invokeSetter(columnInfo.fieldName,
                    rs.getObject(columnInfo.columnName, columnInfo.type),
                    columnInfo.type,
                    entity);
        }
        return entity;
    }

    private T newInstance() {
        try {
            return repositoryClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private <R> void invokeSetter(String fieldName, R value, Class<?> type, T entity) {
        try {
            Method setter = repositoryClass.getMethod(buildSetterName(fieldName), type);
            setter.invoke(entity, value);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private <R> R invokeGetter(String fieldName, T entity) {
        try {
            Method setter = repositoryClass.getMethod(buildGetterName(fieldName));
            return (R) setter.invoke(entity);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private String buildSetterName(String fieldName) {
        return "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    private String buildGetterName(String fieldName) {
        return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    private void createTableIfNotExists() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("create table if not exists ");
        query.append(tableName);
        query.append("( ");
        for (ColumnInfo columnInfo : columns) {
            query.append(columnInfo.columnName);
            query.append(" ");
            query.append("bigserial primary key");
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(");");
        try (Statement stmt = connection.createStatement()) {
            System.out.println(query.toString());
            stmt.execute(query.toString());
        }
    }

    private PreparedStatement buildSelectByIdStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        for (ColumnInfo columnInfo : columns) {
            query.append(columnInfo.columnName);
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(" from ");
        query.append(tableName);
        query.append(" where ");
        query.append(" id = ?");
        query.append(";");
        System.out.println("Select by id statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildInsertStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("insert into ");
        query.append(tableName);
        query.append("(");
        for (ColumnInfo columnInfo : columns) {
            if (!columnInfo.isId) {
                query.append(columnInfo.columnName);
                query.append(",");
            }
        }
        query.deleteCharAt(query.length() - 1);
        query.append(") ");
        query.append("values (");
        query.append("?,".repeat(columns.size() - 1));
        query.deleteCharAt(query.length() - 1);
        query.append(");");
        System.out.println("Insert statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildFindAllStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        for (ColumnInfo columnInfo : columns) {
            query.append(columnInfo.columnName);
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(" from ");
        query.append(tableName);
        query.append(";");
        System.out.println("Find all statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildUpdateStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("update ");
        query.append(tableName);
        query.append(" set ");
        for (ColumnInfo columnInfo : columns) {
            if (!columnInfo.isId) {
                query.append(columnInfo.columnName + " = ? ");
                query.append(",");
            }
        }
        query.deleteCharAt(query.length() - 1);
        query.append(" where ");
        query.append(" id = ?");
        query.append(";");
        System.out.println("Update statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildDeleteStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("delete from ");
        query.append(tableName);
        query.append(" where ");
        query.append(" id = ?");
        query.append(";");
        System.out.println("Delete statement: " + query);
        return connection.prepareStatement(query.toString());
    }


    private static class ColumnInfo {

        private final String fieldName;

        private final String columnName;

        private final Class<?> type;

        private final boolean isId;

        public ColumnInfo(String fieldName, String columnName, Class<?> type, boolean isId) {
            this.fieldName = fieldName;
            this.columnName = columnName;
            this.type = type;
            this.isId = isId;
        }
    }

}