package com.bichpormak;

import java.util.Arrays;

public class LambdaArraySortDemo {

    public static void main(String[] args) {

        String[] arr = {"Java", "Lambda", "Stream", "API"};

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        System.out.println(Arrays.toString(arr));
    }

}