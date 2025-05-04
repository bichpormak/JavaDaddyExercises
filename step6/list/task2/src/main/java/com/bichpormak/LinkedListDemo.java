package com.bichpormak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {

        final LinkedList<String> list = new LinkedList<>()
        {{
            add("Two");
            add("Three");
            add("Four");
        }};

        list.addFirst("One");
        list.addLast("Five");

        System.out.println(list);

        list.removeFirst();
        list.removeLast();

        for (String element : list) {
            System.out.println(element);
        }

    }

}