package ru.geekbrains.lesson5.homework;

public class Fish extends Participant implements Swim {


    public Fish(String name, int maxProjectedLength) {
        super(name, maxProjectedLength);
    }

    @Override
    public void swim() {
    }
}
