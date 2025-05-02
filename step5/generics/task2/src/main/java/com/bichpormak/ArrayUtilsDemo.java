package com.bichpormak;

import java.util.Arrays;

public class ArrayUtilsDemo {

    public static void main(String[] args) {

        final String[] string = {"Вася", "Петя", "Коля", "Андрей"};

        ArrayUtils.swap(string, 1, 3);

        System.out.println(Arrays.toString(string));

    }

}