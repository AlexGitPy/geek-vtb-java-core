package ru.geekbrains.lesson4.homework;

public class Cat extends Action {

    public Cat(String name, int age, int countRun, int countJump) {
        super(name, age, countRun, countJump);
    }

    @Override
    public void run() {
        System.out.println("Run, Cat, Run!!!");
    }

    @Override
    public void jump() {
        System.out.println("Tap, tap");
    }
}
