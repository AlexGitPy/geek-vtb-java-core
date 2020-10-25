package ru.geekbrains.lesson5.homework;

public class Parrot extends Participant implements Flight, Run {

    public Parrot(String name, int maxFlightLength, int maxRunLength) {
        super(name);
        setMaxFlightLength(maxFlightLength);
        setMaxRunLength(maxRunLength);
    }

    @Override
    public void flight() {
    }

    @Override
    public void run() {

    }

}
