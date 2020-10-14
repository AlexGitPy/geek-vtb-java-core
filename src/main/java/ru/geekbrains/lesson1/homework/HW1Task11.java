package ru.geekbrains.lesson1.homework;

public class HW1Task11 {

    public static void main(String[] args) {
        int[] intArr = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] intArr1 = {1, 1, 1, 2, 1};
        int[] intArr2 = {1, 2, 2, 2};
        System.out.println(checkBalance(intArr));
        System.out.println(checkBalance(intArr1));
        System.out.println(checkBalance(intArr2));
    }

    public static boolean checkBalance(int[] intArr) {
        int sum_left = intArr[0];
        int sum_right = intArr[0];
        if (intArr.length == 0) {
            System.out.println("Array is empty");
        } else
            for (int i=0; i < intArr.length; i++) {
                sum_left = intArr[i] + intArr[i+1];
                sum_right = intArr[intArr.length - 1] + intArr[intArr.length - 2];
                for (int j=1; j < intArr.length - 1; j++)
                    if (sum_left < sum_right) {
                        sum_left += intArr[j+1];
                    } else if (sum_left > sum_right) {
                        sum_right += intArr[intArr.length - 2];
                    } else if (sum_left == sum_right) {
                        return true;
                    } else
                        break;
                        return false;
            }
            return true;
    }

}
