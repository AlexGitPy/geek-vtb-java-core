package ru.geekbrains.lesson1.homework;

import java.util.Arrays;

public class HW1Task6 {

    public static void main(String[] args) {

        int[] intArr = new int[8];

        for (int i=0; i < intArr.length; i++) {
            intArr[i] = 2 + i*3;
        }

        System.out.println(Arrays.toString(intArr));

    }

}
