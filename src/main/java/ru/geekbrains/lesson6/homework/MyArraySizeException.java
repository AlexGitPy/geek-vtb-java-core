package ru.geekbrains.lesson6.homework;

public class MyArraySizeException extends Throwable {

    public MyArraySizeException(int max, int i, int j) {
        super("This array is not [" + max + "x" + max + "] in size. Now array size is [" + i + "x" + j + "]");

    }
}
