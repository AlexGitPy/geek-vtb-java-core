package ru.geekbrains.lesson1.homework2;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {

        int arr[] = {10, 8, 6, 2, 5, 11, 1};
        String arrString = Arrays.toString(swap(arr));
        System.out.println(arrString);

    }

    public static int[] swap(int[] arr) {
        for (int i = 0; i < arr.length - i; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }


}
