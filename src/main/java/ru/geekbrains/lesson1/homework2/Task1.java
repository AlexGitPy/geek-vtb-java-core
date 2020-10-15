package ru.geekbrains.lesson1.homework2;

public class Task1 {

    public static void main(String[] args) {
//        pyramid(3);
        pyramidWithWidth(7);
    }

//    public static void pyramid(int h) {
//        for (int i = 0; i < h; i++) {
//            for (int j = 1; j < h * 2; j++) {
//                if (h - i <= j && h + i >= j) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//
//    }

    public static void pyramidWithWidth(int w) {
        if (w % 2 != 0) {
            for (int i = 0; i <= w / 2 + 1; i++) {
                for (int j = 0; j <= w / 2 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i * 2 - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }
}
