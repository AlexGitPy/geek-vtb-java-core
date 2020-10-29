package ru.geekbrains.lesson8.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {

        Task1 task1 = new Task1();

        String[] words = new String[12];
        words[0] = "Создать";
        words[1] = "массив";
        words[2] = "массив";
        words[3] = "набором";
        words[4] = "слов";
        words[5] = "слов";
        words[6] = "должны";
        words[7] = "встречаться";
        words[8] = "повторяющиеся";
        words[9] = "Найти";
        words[10] = "вывести";
        words[11] = "список";
        System.out.println(Arrays.toString(words));
        System.out.println(task1.wordUnique(words));
        System.out.println(task1.wordCounts(words));
    }

    public Map<String, String> wordUnique(String[] words) {
        Map<String, String> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!wordCounts.containsKey(words)) {
                wordCounts.put(word, "unique");
            }
        }
        return wordCounts;

    }

    public Map<String, Integer> wordCounts(String[] words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }
        return wordCounts;
    }

}
