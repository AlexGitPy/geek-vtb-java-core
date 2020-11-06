package ru.geekbrains.lesson9.homework;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task2 {


    public static void main(String[] args) {

        Task2 task2 = new Task2();

        task2.fileStitching("1.txt", "2.txt", "3.txt");


    }

    public void fileStitching(String file1, String file2, String file3) {

        List<Path> inputs = Arrays.asList(
                Paths.get(file1),
                Paths.get(file2)
        );

        Path output = Paths.get(file3);

        Charset charset = StandardCharsets.UTF_8;

        for (Path path : inputs) {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(path, charset);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Files.write(output, lines, charset, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
