package ru.geekbrains.lesson1.homework;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task08 {

    public static void main(String[] args) {

        int[][] intArr = new int[5][5];

        fillDiags(intArr);

        for (int[] line : intArr) {
            System.out.println(Arrays.toString(line));
        }
    }

    public static void fillDiags(int[][] intArr) {
        for (int i=0; i<intArr.length; i++) {
            intArr[i][i] = 1;
            intArr[i][intArr.length - i - 1] = 1;
        }
    }

}
