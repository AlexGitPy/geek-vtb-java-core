package ru.geekbrains.lesson9.homework;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task1 {


    private final String file = "C:\\Users\\admim\\IdeaProjects\\geek-vtb-java-core\\" +
            "src\\main\\java\\ru\\geekbrains\\lesson9\\homework\\task1.txt";

    public static void main(String[] args) {

        Task1 task1 = new Task1();

        task1.numberOfRepetitions(task1.file, "aaa");


    }


    public void numberOfRepetitions(String file, String repetition) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            Set<String> words = new HashSet<>(lines);
            int i = 0;
            for (String word : words) {
                if (word.contains(repetition)) {
                    i++;
                }
            }
            System.out.println("Number of repetitions: " + i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
