package ru.geekbrains.lesson1.homework;

public class HW1Task9 {

    public static void main(String[] args) {

        int[] intArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = intArr[0];
        int max = intArr[0];
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] < min) {
                min = intArr[i];
            }
            if (intArr[i] > max) {
                max = intArr[i];
            }

        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);

    }

}
