package com.bichpormak;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        final Map<String, Integer> map = new HashMap<>()
        {{
            put("Alice", 85);
            put("Bob", 72);
            put("Charlie", 90);
            put("Diana", 68);
        }};

        for (Map.Entry<String, Integer> element : map.entrySet()) {
            if (element.getValue() > 75) {
                System.out.println(element);
            }
        }

    }

}