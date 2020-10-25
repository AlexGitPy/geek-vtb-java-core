package ru.geekbrains.lesson5.homework;

public class Human extends Participant implements Run, Jump, Swim {


    public Human(String name, int maxRunLength, int maxJumpHeight, int maxProjectedLength) {
        super(name, maxRunLength, maxJumpHeight, maxProjectedLength);
    }

    @Override
    public void jump() {
    }

    @Override
    public void run() {
    }

    @Override
    public void swim() {
    }
}
