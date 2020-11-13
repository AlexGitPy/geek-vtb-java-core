package ru.geekbrains.lesson12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    static List<String> lines = new ArrayList<>(Arrays.asList(
            "dfssdf sdfsa sdf asdfasdf asdfasdf asdfas dfaf safd sfads asfd sdf asdf asdf asdf asdf asdf asdfa asdf " +
                    "fdsfsdf sdf sdf sdf sdfdsf sdf sdfsdf sdf sdf sdf asdsdfsd sdfsdf sdf sdf sdfsdf ggg" +
                    "dfssdf sdfsa sdf asdfasdf asdfasdf asdfas dfaf safd sfads asfd sdf asdf asdf asdf as dfasdf " +
                    "dfssdf sdfsa sdf asdfasdf asdfasdf asdfas dfaf safd sfads asfd sdf asdf asdf asdf asdf asdf asd fa asdf " +
                    "Взять строку состоящую из ста слов разделенных пробелом получить список слов длиннее пяти символов" +
                    "и склеить их в одну строку с пробелом в качестве разделителя Найти список уникальных слов в двумерном массиве размером"
    ));

    public static void main(String[] args) {

        long count = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .count();

        System.out.println("Words in lines: " + count);

        String reduce = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.length() > 5)
                .collect(Collectors.joining(" "));
        System.out.println(reduce);
    }
}
