package com.bichpormak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedArrayListDemo {

    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<>(Arrays.asList(42, 17, 8, 99, 23));

        Collections.sort(list);

        System.out.println(list);
    }

}