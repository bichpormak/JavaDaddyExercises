package com.bichpormak;

import java.util.Arrays;
import java.util.List;

public class AverageValueDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        list.stream()
                .mapToInt(o1 -> o1)
                .average()
                .ifPresent(System.out::println);

    }

}