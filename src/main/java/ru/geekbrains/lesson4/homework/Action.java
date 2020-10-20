package ru.geekbrains.lesson4.homework;

public abstract class Action {

    private String name;

    private  int age;

    private int countRun;

    private int countJump;

    public Action(String name, int age, int countRun, int countJump) {
        this.name = name;
        this.age = age;
        this.countRun = countRun;
        this.countJump = countJump;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCountRun() {
        return countRun;
    }

    public int getCountJump() {
        return countJump;
    }

    public abstract void run();

    public abstract void jump();

}
