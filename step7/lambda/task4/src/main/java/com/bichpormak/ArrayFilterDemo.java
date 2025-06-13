package com.bichpormak;

import java.util.Arrays;
import java.util.List;

public class ArrayFilterDemo {

    public static void main(String[] args) {

        Integer[] arr = {5, 12, 7, 20, 3};

        List<Integer> result = filterArray(arr, o1 -> o1 > 10);

        System.out.println(result);

    }

    public static <T> List<T> filterArray(T[] array, MyPredicate<T> predicate) {

        return Arrays.stream(array)
                .filter(predicate::test)
                .toList();

    }

}