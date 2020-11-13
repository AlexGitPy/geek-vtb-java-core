package ru.geekbrains.lesson12.homework;

import java.util.stream.IntStream;

public class Task3 {

    public static void main(String[] args) {
        int s = IntStream.range(100, 201)
                .filter(x -> x%2 == 0)
                .sum();
        System.out.println(s);
    }

}
