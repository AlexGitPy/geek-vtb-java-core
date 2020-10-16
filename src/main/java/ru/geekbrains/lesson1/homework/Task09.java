package ru.geekbrains.lesson1.homework;

public class Task09 {

    public static void main(String[] args) {

        int[] intArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = intArr[0];
        int max = intArr[0];
        for (int j : intArr) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }

        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);

    }

}
