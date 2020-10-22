package ru.geekbrains.lesson5.homework;

public abstract class Participant {

    private final String name;

    private int maxFlightLength;

    private int maxRunLength;

    private int maxJumpHeight;

    private int maxProjectedLength;

    public Participant(String name) {
        this.name = name;
    }

    public Participant(String name, int maxRunLength, int maxJumpHeight, int maxProjectedLength) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        this.maxProjectedLength = maxProjectedLength;
    }

    public Participant(String name, int maxRunLength, int maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public Participant(String name, int maxProjectedLength) {
        this.name = name;
        this.maxProjectedLength = maxProjectedLength;
    }


    public String getName() {
        return name;
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxProjectedLength() {
        return maxProjectedLength;
    }

    public int getMaxFlightLength() {
        return maxFlightLength;
    }

    public void setMaxFlightLength(int maxFlightLength) {
        this.maxFlightLength = maxFlightLength;
    }

    public void setMaxRunLength(int maxRunLength) {
        this.maxRunLength = maxRunLength;
    }

    public void setMaxJumpHeight(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public void setMaxProjectedLength(int maxProjectedLength) {
        this.maxProjectedLength = maxProjectedLength;
    }
}
