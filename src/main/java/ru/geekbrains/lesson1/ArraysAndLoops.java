package ru.geekbrains.lesson1;

import java.util.Arrays;
import java.util.Random;

public class ArraysAndLoops {

    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 6};
        int[] intArr1 = new int[12];

        System.out.println(intArr[0]);
        System.out.println(intArr.length); // длина массива

        Random rnd = new Random();

        for (int i=0; i < intArr1.length; i++) {
            intArr1[i] = rnd.nextInt();
        }

        for (int j : intArr1) {
            System.out.println(j);
        }

        System.out.println(Arrays.toString(intArr1));

        int val = 2;
        while (val < 100) {
            val *= 2;
        }

//        do {
//
//        } while ();

        // Бесконечные циклы

//        for (;;) {
//
//        }
//
//        while (true) {
//
//        }

//        intArr1[1] = rnd.nextInt();
//        intArr1[0] = rnd.nextInt();
    }

}
