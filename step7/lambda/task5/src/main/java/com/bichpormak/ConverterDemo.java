package com.bichpormak;

import java.util.Arrays;

public class ConverterDemo {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        int[] result = convertArray(arr, o1 -> o1 * o1);

        System.out.println(Arrays.toString(result));

    }

    public static int[] convertArray(int[] array, Converter converter) {

        return Arrays.stream(array)
                .map(converter::convert)
                .toArray();

    }

}