package ru.geekbrains.lesson6.homework;

public class Task1 {

    private static final int MAX = 4;


    public static void main(String[] args) throws MyArrayDataException {

        String[][] arr = {
                {"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}
        };
        try {
            System.out.println(ArrayStringToInt(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }


        String[][] arr1 = {
                {"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        try {
            System.out.println(ArrayStringToInt(arr1));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }


        String[][] arr2 = {
                {"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "`", "11", "12"}, {"13", "14", "15", "16"}
        };
        try {
            System.out.println(ArrayStringToInt(arr2));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

    }



    public static int ArrayStringToInt(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != MAX) {
            throw new MyArraySizeException(MAX, arr.length, arr[0].length);

        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != MAX) {
                throw new MyArraySizeException(MAX, arr.length, arr[0].length);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        System.out.print("Sum = ");
        return sum;
    }
}

