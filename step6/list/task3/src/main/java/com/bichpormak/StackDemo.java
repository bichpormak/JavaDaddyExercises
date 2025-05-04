package com.bichpormak;

import java.util.List;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        final Stack<String> stack = new Stack<>()
        {{
            push("First");
            push("Second");
            push("Third");
        }};

        System.out.println(stack.peek());

        while (!stack.isEmpty()) {

            System.out.println(stack.pop());

        }

    }

}