package ru.geekbrains.lesson1.homework;

public class HW1Task10 {

    public static void main(String[] args) {
        leapYear(2020);
    }

    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0){
            System.out.println("Leap year!");
        } else if (year % 4 == 0 && year % 400 == 0) {
            System.out.println("Leap year!");
        } else
            System.out.println("Not a leap year");
    }

}
