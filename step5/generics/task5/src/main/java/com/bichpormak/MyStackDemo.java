package com.bichpormak;

import java.util.Arrays;
import java.util.List;

public class MyStackDemo {

    public static void main(String[] args) {

        final MyStack<String> stack =
                new MyStack<>(List.of("Abobus1", "Abobus2"));

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        stack.pop();

        stack.push("Aloha");
        System.out.println(stack.peek());
        System.out.println(stack);

    }

}