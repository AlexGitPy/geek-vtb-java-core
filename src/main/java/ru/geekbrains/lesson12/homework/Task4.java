package ru.geekbrains.lesson12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {

    static List<String> lines = new ArrayList<>(Arrays.asList(
            "Посчитать",
            "суммарную",
            "длину",
            "строк",
            "в",
            "одномерном",
            "массиве"
    ));

    public static void main(String[] args) {

        long collect = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(""))).count();

        System.out.println(collect);

    }

}
