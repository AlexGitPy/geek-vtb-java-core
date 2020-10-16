package ru.geekbrains.lesson1.homework;

public class Task03 {

    public static void main(String[] args) {
        System.out.println(checkBooleanNumber(-1));
    }

    public static boolean checkBooleanNumber(int intValue) {
        if (intValue < 0) {
            return true;
        } else
            return false;
    }

}
