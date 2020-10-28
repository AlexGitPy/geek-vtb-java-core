package ru.geekbrains.lesson6.homework;

public class MyArrayDataException extends Throwable {

    public MyArrayDataException(int i, int j) {
        super("Incorrect data in cell: [" + i + "x" + j + "]");
    }

}
