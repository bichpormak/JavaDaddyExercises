package com.bichpormak;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        final Queue<String> queue = new LinkedList<>()
        {{
            offer("A");
            offer("B");
            offer("C");
        }};

        System.out.println(queue);

        System.out.println(queue.poll() + " " + queue);
        System.out.println(queue.peek() + " " + queue);

    }

}