package ru.geekbrains.lesson1.homework2;

public class Task3 {

    public static void main(String[] args) {
        int time = 3750;
        dataTime(time);

    }

    public static void dataTime(int time) {
        int hh = time / 60 / 60;
        int mm = time / 60 % 60;
        int ss = time % 60;
        String s = String.format("%02d:%02d:%02d", hh, mm, ss);
        System.out.println(s);
    }


}
