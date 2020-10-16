package ru.geekbrains.lesson1.homework;

public class Task01 {

    public static void main(String[] args) {
        System.out.println(sumInRange(10, 0));
    }

    public static boolean sumInRange(int firstValue, int secondValue) {
        int sum = firstValue + secondValue;
        return sum >= 10 && sum <= 20;
    }

}
