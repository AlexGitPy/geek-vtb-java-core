package ru.geekbrains.lesson11.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestRepository {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres",
                "postgres", "1234");

        Repository<User> userRepository = new Repository<>(User.class, connection);

        userRepository.insert(new User(null, "ccc", "ccc"));
        userRepository.insert(new User(null, "ddd", "ddd"));
        userRepository.insert(new User(null, "fff", "fff"));
        userRepository.insert(new User(null, "bbb", "bbb"));
        System.out.println(userRepository.findAll());

        userRepository.update(new User(2L, "aaa", "aaa"));
        System.out.println(userRepository.findAll());

        User user = userRepository.findById(4L);
        System.out.println(user);

        userRepository.delete(1L);

        System.out.println(userRepository.findAll());

    }

}
