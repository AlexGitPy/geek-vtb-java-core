package ru.geekbrains.lesson1.homework;

public class Task10 {

    public static void main(String[] args) {
        System.out.println(leapYear(2020));
    }

    public static boolean leapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
