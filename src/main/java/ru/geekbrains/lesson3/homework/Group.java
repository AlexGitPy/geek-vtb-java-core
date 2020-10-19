package ru.geekbrains.lesson3.homework;

public class Group {

    private Employees[] emp = new Employees[10];
    private int count = -1;


    public static void main(String[] args) {
        Employees employees = new Employees(1, "Vasya", "sasdas@asda.rg", 27, "director");
        Employees employees1 = new Employees(1, "Ivan", "example@asda.ru", 42, "Developer");
        Employees employees2 = new Employees(1, "Petya", "example1231@asda.ru", 22, "Developer");
        Group group = new Group();
        group.addEmployee(employees, employees1, employees1, employees2);
        group.allEmployee();
        group.removeEmployee(2);
        group.allEmployee();
        group.removeAll();
        group.allEmployee();
    }


    public void addEmployee(Employees... newEmp) {
        for (Employees employees : newEmp) {
            boolean isNoPlace = true;
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] == null) {
                    emp[i] = employees;
                    isNoPlace = false;
                    count++;
                    break;
                }
            }
            if (isNoPlace) {
                System.out.println("No place for all employees");
                break;
            }
        }
    }

    public void removeEmployee(int index) {
        if (emp[index] != null) {
            emp[index] = null;
            count--;
        } else {
            System.out.println("Employee not found");
        }
    }

    public void removeAll() {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i] != null) {
                emp[i] = null;
            }
        }
        count = -1;
    }

    public void allEmployee() {
        for (Employees employees : emp) {
            if (employees != null) {
                System.out.println("-------------------------------------------------------------");
                employees.printInfo();
            }
        }
        System.out.println("*****************************************************************");
    }

}

