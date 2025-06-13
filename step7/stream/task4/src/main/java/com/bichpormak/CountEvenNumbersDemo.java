package com.bichpormak;

import java.util.Arrays;

public class CountEvenNumbersDemo {

    public static void main(String[] args) {

        int[] arr = {10, 15, 20, 25, 30, 35};

        long result = Arrays.stream(arr)
                .filter(o1 -> o1 % 2 == 0)
                .count();

        System.out.println(result);

    }

}