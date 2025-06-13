package com.bichpormak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonToMapDemo {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>()
        {{
            add(new Person("abobus1", 15));
            add(new Person("abobus2", 20));
            add(new Person("abobus3", 25));
        }};

        Map<String, Integer> result = list.stream()
                .collect(Collectors.toMap(Person::name, Person::age));

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry);
        }

    }

}