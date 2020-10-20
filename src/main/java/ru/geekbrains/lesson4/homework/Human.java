package ru.geekbrains.lesson4.homework;

public class Human extends Action {

    public Human(String name, int age, int countRun, int countJump) {
        super(name, age, countRun, countJump);
    }

    @Override
    public void run() {
        System.out.println("Run, Forest, Run!!!");
    }

    @Override
    public void jump() {
        System.out.println("Opa");
    }
}
