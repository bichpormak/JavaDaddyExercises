package com.bichpormak;

public class OperationDemo {

    public static void main(String[] args) {

        for (Operation operation : Operation.values()) {
            System.out.println(operation.apply(7.4, 2.1));
        }

    }

}