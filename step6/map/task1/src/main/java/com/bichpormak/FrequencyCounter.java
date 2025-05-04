package com.bichpormak;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FrequencyCounter {

    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        map.put("Apple", calculateContains("Apple"));
        map.put("Banana", calculateContains("Banana"));
        map.put("Apple", calculateContains("Apple"));
        map.put("Orange", calculateContains("Orange"));
        map.put("Banana", calculateContains("Banana"));
        map.put("Apple", calculateContains("Apple"));

        System.out.println(map);

    }

    private static int calculateContains(String element) {

        for (Map.Entry<String, Integer> currentEntry : map.entrySet()) {

            if (currentEntry.getKey().equals(element)) {
                return currentEntry.getValue() + 1;
            }

        }

        return 1;

    }

}