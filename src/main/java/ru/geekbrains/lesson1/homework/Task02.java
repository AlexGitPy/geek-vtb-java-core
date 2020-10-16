package ru.geekbrains.lesson1.homework;

public class Task02 {

    public static void main(String[] args) {
        positiveOrNegative(0);
    }

    public static void positiveOrNegative(int intValue) {
        if (intValue >= 0) {
            System.out.println("Positive number");
        } else
            System.out.println("Negative number");
    }

}
