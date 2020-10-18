package ru.geekbrains.lesson3.homework;


public class Group {

    private Employee[] emp = new Employee[10];
    private int count = -1;



    public static void main(String[] args) {
        Group group = new Group();
        group.addEmployee("Alex", "example1@mail.ru", 41, "Developer");
        group.addEmployee("Alex1", "example1@mail.ru1", 411, "Developer1");
        group.allEmployee();
        group.removeEmployee(1);
        group.allEmployee();
        group.addEmployee("Alex112", "example1@mail.ru112", 4112, "Developer112");
        group.allEmployee();
        group.removeAll();
        group.allEmployee();
    }


    public void addEmployee(String name, String email, int age, String position) {
        Employee employee = new Employee(name, email, age, position);
        if (count < emp.length) {
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] == null) {
                    emp[i] = employee;
                    break;
                }
            }
            count++;
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
        for (int i = 0; i < emp.length; i++) {
            if (emp[i] != null) {
                System.out.print("Index: " + i + " Name: " + Employee.name + " Email: " + Employee.email + " Age: " + Employee.age + " Position: " + Employee.position +"\n");
            }
        }
        System.out.println();
    }



    public static class Employee {

        private static String name;
        private static String email;
        private static int age;
        private static String position;


        public Employee(String name, String email, int age, String position) {
            this.name = name;
            this.email = email;
            this.age = age;
            this.position = position;
        }
    }
}
