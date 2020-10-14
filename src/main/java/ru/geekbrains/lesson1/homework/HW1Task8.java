package ru.geekbrains.lesson1.homework;

public class HW1Task8 {

    public static void main(String[] args) {

        int[][] intArr = new int[5][5];
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0, k = intArr[i].length; j < intArr[i].length; j++, k--) {
                if (i == j || i == (k - 1)) intArr[i][j] = 1;
                System.out.print(intArr[i][j] + " ");
            }
            System.out.print("\r\n");
        }

    }

}
