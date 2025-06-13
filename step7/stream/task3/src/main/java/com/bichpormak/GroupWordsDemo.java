package com.bichpormak;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsDemo {

    public static void main(String[] args) {

        String[] arr = {"apple", "ant", "banana", "berry", "cherry", "carrot"};

        Map<Character, List<String>> result = Arrays.stream(arr)
                .collect(Collectors.groupingBy(o1 -> o1.charAt(0)));

        for (Map.Entry<Character, List<String>> element : result.entrySet()) {
            System.out.println(element);
        }
    }

}