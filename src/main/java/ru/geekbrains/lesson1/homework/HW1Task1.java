package ru.geekbrains.lesson1.homework;

public class HW1Task1 {

    public static void main(String[] args) {
        System.out.println(sumInRange(10, 0));
    }

    public static boolean sumInRange(int firstValue, int secondValue) {
        int sum = firstValue + secondValue;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

}
