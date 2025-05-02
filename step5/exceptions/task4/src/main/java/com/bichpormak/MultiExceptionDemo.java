package com.bichpormak;

public class MultiExceptionDemo {

    public static void main(String[] args) {

        final String[] arr = {"Abobus", "Abobus2"};

        try {

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println(arr[i].length());
            }

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Вы вышли за пределы массива");
        }

    }

}