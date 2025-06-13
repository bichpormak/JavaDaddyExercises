package com.bichpormak;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoinStringsDemo {

    public static void main(String[] args) {

        String[] arr = {"red", "green", "blue", "yellow"};

        String result = Arrays.stream(arr)
                .collect(Collectors.joining(", "));

        System.out.println(result);

    }

}