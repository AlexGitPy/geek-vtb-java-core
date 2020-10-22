package ru.geekbrains.lesson5.homework;

public class Cat extends Participant implements Run, Jump {


    public Cat(String name, int maxRunLength, int maxJumpHeight) {
        super(name, maxRunLength, maxJumpHeight);
    }

    @Override
    public void jump() {
    }

    @Override
    public void run() {
    }
}
