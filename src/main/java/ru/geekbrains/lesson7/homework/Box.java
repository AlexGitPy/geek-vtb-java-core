package ru.geekbrains.lesson7.homework;

import java.util.ArrayList;

import java.util.Arrays;

public class Box<T extends Fruit> {

    ArrayList<T> fruitBox = new ArrayList<>();

    public Box(T... fruit) {
        fruitBox = new ArrayList<>(Arrays.asList(fruit));
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange(), new Orange(), new Orange());
        Box<Orange> secondOrangeBox = new Box<>();
        System.out.println("appleBox weight " + appleBox.getWeight());
        System.out.println("orangeBox weight " + orangeBox.getWeight());
        System.out.println();
        System.out.println(appleBox.compare(orangeBox));
        orangeBox.replaceFruits(secondOrangeBox);
        System.out.println(orangeBox.getFruitBox());
        System.out.println(secondOrangeBox.getFruitBox());
        System.out.println("Second OrangeBox weight " + secondOrangeBox.getWeight());
        System.out.println("orangeBox weight " + orangeBox.getWeight());
        secondOrangeBox.addFruit(new Orange());
        System.out.println("Second OrangeBox weight " + secondOrangeBox.getWeight());


    }

    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    public void addFruit(T fruit) {
        fruitBox.add(fruit);
        System.out.println("Fruit is add");
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < fruitBox.size(); i++) {
            totalWeight += fruitBox.get(i).getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) == 0.0f;
    }

    public void replaceFruits(Box<T> anotherBox) {
        anotherBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }
}