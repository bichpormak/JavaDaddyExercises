package com.bichpormak;

import java.util.ArrayList;
import java.util.List;

public class PersonSortDemo {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>()
        {{
            add(new Person("abobus3", 30));
            add(new Person("abobus2", 10));
            add(new Person("abobus1", 30));
            add(new Person("abobus4", 40));
            add(new Person("abobus5", 50));
        }};

        list.stream()
                .sorted( (o1, o2) -> {
                    {
                        if (o1.age() != o2.age()) {
                            return o1.age() - o2.age();
                        } else {
                            return String.CASE_INSENSITIVE_ORDER.compare(o1.name(), o2.name());
                        }
                    }
                })
                .forEach(System.out::println);

    }

}