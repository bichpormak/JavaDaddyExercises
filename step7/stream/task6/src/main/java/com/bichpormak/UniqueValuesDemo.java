package com.bichpormak;

import java.util.Arrays;

public class UniqueValuesDemo {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 3, 5, 1};

        Arrays.stream(arr)
                .distinct()
                .forEach(System.out::println);

    }

}