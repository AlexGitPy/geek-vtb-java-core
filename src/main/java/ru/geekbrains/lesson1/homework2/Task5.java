package ru.geekbrains.lesson1.homework2;

import java.util.Arrays;

public class Task5 {

    public static void main(String[] args) {
        int arr[] = {10, 8, 6, 2, 5, 11, 1};
        String arrString = Arrays.toString(randomMas(arr));
        System.out.println(arrString);
    }

    public static int[] randomMas(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
