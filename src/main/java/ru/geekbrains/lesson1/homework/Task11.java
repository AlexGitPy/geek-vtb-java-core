package ru.geekbrains.lesson1.homework;

public class Task11 {

    public static void main(String[] args) {
        int[] intArr = {2, 2, 2, 1, 2, 2, 10, 1};
        int median = findMedian(intArr);
        System.out.println(median);
    }

    public static int findMedian(int[] intArr) {
        int rightSum = 0;
        for (int val : intArr) {
            rightSum += val;
        }

        int leftSum = 0;
        for (int i=0; i<intArr.length; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += intArr[i];
            rightSum -= intArr[i];
        }
        return -1;
    }

}
