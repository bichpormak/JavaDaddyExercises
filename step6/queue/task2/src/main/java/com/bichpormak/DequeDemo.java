package com.bichpormak;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {

        final Deque<Integer> deque = new LinkedList<>()
        {{
            addFirst(10);
            addFirst(20);
            addLast(50);
            addLast(60);
        }};

        System.out.println(deque);

        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque);

    }

}