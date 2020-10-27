package ru.geekbrains.lesson7.homework;

public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
