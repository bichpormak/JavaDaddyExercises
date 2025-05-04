package com.bichpormak;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        final Set<String> set = new HashSet<>()
        {{
            add("Banana");
            add("Apple");
            add("Banana");
        }};


        for (String element : set) {
            System.out.println(element);
        }

    }

}