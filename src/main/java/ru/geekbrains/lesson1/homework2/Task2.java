package ru.geekbrains.lesson1.homework2;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        int arr[] = {10, 8, 6, 2, 5};
        String arrString = Arrays.toString(selectionSort(arr));
        System.out.println(arrString);

    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

}
