package com.bichpormak;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FinallyDemo {

    public static void main(String[] args) {

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на ноль");
        } finally {
            System.out.println("ресурс закрыт");
        }

    }

}