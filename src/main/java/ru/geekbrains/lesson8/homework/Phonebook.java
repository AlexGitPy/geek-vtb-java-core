package ru.geekbrains.lesson8.homework;

import java.util.*;

public class Phonebook {

    public static void main(String[] args) {

        Phonebook phonebookEx = new Phonebook();

        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("+799999999", "Бубликова");
        phonebook.put("+799999991", "Бубликова");
        phonebook.put("+799999992", "Серебряков");

        phonebookEx.add(phonebook, "+7999999921", "Ермаков");
        System.out.println(phonebook);

        phonebookEx.get(phonebook, "Бубликова");

    }

    public void add(Map<String, String> phonebook,String phoneNumber, String lastName) {
        phonebook.put(phoneNumber, lastName);
    }

    public void get(Map<String, String> phonebook, String lastName) {
        for(Map.Entry entry: phonebook.entrySet()) {
            if (Objects.equals(lastName, entry.getValue())) {
                String key = (String) entry.getKey();
                System.out.println(key);
            }
        }
    }

}
