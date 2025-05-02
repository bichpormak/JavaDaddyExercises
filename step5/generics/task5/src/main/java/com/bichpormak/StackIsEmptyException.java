package com.bichpormak;

public class StackIsEmptyException extends RuntimeException {

    public StackIsEmptyException() {
        super("Stack is empty");
    }

}
