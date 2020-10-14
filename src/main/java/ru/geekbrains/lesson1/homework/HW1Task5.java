package ru.geekbrains.lesson1.homework;

import java.util.Arrays;

public class HW1Task5 {

    public static void main(String[] args) {

        int[] intArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i=0; i < intArr.length; i++) {
            if (intArr[i] != 1) {
                intArr[i] = 1;
            }
        }

        System.out.println(Arrays.toString(intArr));

    }

}
