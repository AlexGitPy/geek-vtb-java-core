package ru.geekbrains.lesson9.homework;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Task2 {

    private final String directory = "C:\\Users\\admim\\IdeaProjects\\geek-vtb-java-core\\";

    public void joinTextFiles(String directory, String fileToJoin) throws IOException {
        File path = new File(directory);
        File[] filesList = path.listFiles();
        Scanner sc;
        FileWriter writer = new FileWriter(directory + "\\" + fileToJoin);
        for (File file : Objects.requireNonNull(filesList)) {
            if (file.isFile()) {
                sc = new Scanner(file);
                String input;
                while (sc.hasNextLine()) {
                    input = sc.nextLine();
                    writer.write(input + "\n");
                }
            }
        }
        writer.close();
    }


    public static void main(String[] args) throws IOException {

        Task2 task2 = new Task2();

        task2.joinTextFiles(task2.directory, "task2.txt");

    }


}
