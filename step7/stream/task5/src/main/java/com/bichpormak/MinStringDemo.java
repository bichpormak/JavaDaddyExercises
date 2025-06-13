package com.bichpormak;

import java.util.Arrays;

public class MinStringDemo {

    public static void main(String[] args) {

        String[] animals = {"elephant", "cat", "hippopotamus", "dog", "lion"};

        Arrays.stream(animals)
                .min((o1, o2) -> o1.length() - o2.length())
                .ifPresent(System.out::println);

    }

}