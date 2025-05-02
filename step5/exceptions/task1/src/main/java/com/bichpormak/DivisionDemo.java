package com.bichpormak;

public class DivisionDemo {

    public static void main(String[] args) {

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на нуль");
        }

    }

}