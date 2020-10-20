package ru.geekbrains.lesson4.homework;

public class Robot extends Action {

    public Robot(String name, int age, int countRun, int countJump) {
        super(name, age, countRun, countJump);
    }

    @Override
    public void run() {
        System.out.println("I can't run, i'm a robot :(");
    }

    @Override
    public void jump() {
        System.out.println("Leather bastard, i can't jump!!!");
    }
}
