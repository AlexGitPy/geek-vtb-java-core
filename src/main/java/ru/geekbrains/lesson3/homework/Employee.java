package ru.geekbrains.lesson3.homework;

import java.util.Scanner;

public class Employee {

    private String name;
    private String email;
    private int age;
    private String position;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.print("Write employee name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Write employee email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("Write the age of the employee: ");
        employee.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Write an employee position: ");
        employee.setPosition(scanner.nextLine());
        System.out.println(employee.getName() +"\n"+ employee.getEmail() +"\n"+ employee.getAge() +"\n"+ employee.getPosition());

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = name;
        } else {
            System.out.println("Incorrect name");
        }
    }

    public void setEmail(String email) {
        if (email == null ) {
            this.email = email;
        } else {
            System.out.println("Incorrect email");
        }
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Incorrect age");
        }
    }

    public void setPosition(String position) {
        if (position == null) {
            this.position = position;
        } else {
            System.out.println("Incorrect position");
        }
    }

}
