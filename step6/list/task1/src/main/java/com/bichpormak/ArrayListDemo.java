package com.bichpormak;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<>()
        {{
            add(5);
            add(7);
            add(1);
            add(9);
            add(0);
        }};


        list.remove(Integer.valueOf(1));

        for (Integer element : list) {
            System.out.println(element);
        }

    }

}