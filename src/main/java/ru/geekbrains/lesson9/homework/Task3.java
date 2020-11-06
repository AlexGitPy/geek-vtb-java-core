package ru.geekbrains.lesson9.homework;

import java.io.File;
import java.util.Objects;

public class Task3 {

    private final String path = "C:\\Users\\admim\\IdeaProjects\\geek-vtb-java-core\\" +
            "src\\main\\java\\ru\\geekbrains\\lesson9\\homework\\task3";

    public static void main(String[] args) {

        Task3 task3 = new Task3();

        task3.removeDirectory(task3.path);

    }

    public static void removeDirectory(String path) {

        File dir = new File(path);

        try {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                if (file.isDirectory()) {
                    removeDirectory(String.valueOf(file));
                } else {
                    file.delete();
                }
            }

            dir.delete();

            System.out.printf("Directory %s is delete%n", dir.getName());
        } catch (Exception e) {
            System.out.printf("Directory %s not found", dir.getName());
        }
    }

}
