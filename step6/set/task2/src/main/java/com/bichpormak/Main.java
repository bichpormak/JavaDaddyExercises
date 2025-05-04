package com.bichpormak;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        final Set<Integer> set = new TreeSet<>()
        {{
            add(50);
            add(20);
            add(40);
            add(10);
            add(30);
        }};

        System.out.println(set);

    }

}