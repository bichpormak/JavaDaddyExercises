package com.bichpormak;

import java.util.ArrayList;
import java.util.List;

public class PersonFilterDemo {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>()
        {{
            add(new Person("abobus1", 33));
            add(new Person("abobus2", 17));
            add(new Person("abobus3", 0));
            add(new Person("abobus4", 90));
            add(new Person("abobus5", 43));
            add(new Person("abobus6", 30));
        }};

        people.stream()
                .filter(o1 -> o1.age() > 30)
                .forEach(System.out::println);

    }

}
