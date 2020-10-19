package ru.geekbrains.lesson3.homework;

public class Employees {

    private  String name;
    private String email;
    private int age;
    private String position;
    private long id;

    public Employees() {

    }

    public Employees(long id, String name, String email, int age, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.position = position;
    }

    public long getId() {
        return id;
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

    public void printInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email " + getEmail());
        System.out.println("Age " + getAge());
        System.out.println("Position " + getPosition());
    }

}