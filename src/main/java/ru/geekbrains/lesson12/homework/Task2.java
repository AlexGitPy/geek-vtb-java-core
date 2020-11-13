package ru.geekbrains.lesson12.homework;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {


    public static void main(String[] args) {
        String[][] arr = {{"Найти", "список", "уникальных", "слов", "в"}, {"двумерном", "массиве", "размером", "пять", "пять"}};

        System.out.println(Arrays.stream(arr).
                flatMap((Function<String[], Stream<String>>) Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));


        /*
        В коментах написал без лямбды, чтобы лучше понять, для меня это было самое сложное задание
         */

//        System.out.println(Arrays.stream(arr)
//                .flatMap((new StringStreamFunction()))
//                .distinct()
//                .collect(Collectors.toList()));
    }

//    public static class StringStreamFunction implements Function<String[], Stream<?>> {
//        @Override
//        public Stream<?> apply(String[] strings) {
//            return Arrays.stream(strings);
//        }
//
//
//    }

}