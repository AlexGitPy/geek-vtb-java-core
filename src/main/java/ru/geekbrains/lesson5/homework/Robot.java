package ru.geekbrains.lesson5.homework;

public class Robot extends Participant implements Run {

    public Robot(String name, int maxRunLength) {
        super(name);
        setMaxRunLength(maxRunLength);
    }

    @Override
    public void run() {
    }
}
