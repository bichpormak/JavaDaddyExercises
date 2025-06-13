package com.bichpormak;

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator calculator = Integer::sum;

        System.out.println(calculator.operate(5, 3));

    }

}