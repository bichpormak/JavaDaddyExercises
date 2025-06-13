package com.bichpormak;

import java.util.Arrays;

public class SquareNumbersDemo {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Arrays.stream(arr)
                .map(o1 -> o1 * o1)
                .forEach(System.out::println);

    }

}