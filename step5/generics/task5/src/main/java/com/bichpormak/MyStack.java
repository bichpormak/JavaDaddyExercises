package com.bichpormak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyStack<T> {

    private final List<T> stack = new ArrayList<>();

    public MyStack() {

    }

    public MyStack(Collection<? extends T> collection) {
        stack.addAll(collection);
    }


    public void push(T element) {
        stack.add(element);
    }

    public T pop() {

        if (stack.isEmpty()) {
            throw new StackIsEmptyException();
        }

        final T element = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return element;

    }

    public T peek() {

        if (stack.isEmpty()) {
            throw new StackIsEmptyException();
        }

        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "Elements: " + Arrays.toString(stack.toArray());
    }
}
