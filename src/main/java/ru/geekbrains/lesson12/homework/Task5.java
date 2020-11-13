package ru.geekbrains.lesson12.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Task5 {

    static List<String> lines = new ArrayList<>(Arrays.asList(
            "массива",
            "слов",
            "получить",
            "первые",
            "три"
    ));

    public static void main(String[] args) {

        List<String> distinct = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .limit(3)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Words in lines: " + distinct);



    }
}
