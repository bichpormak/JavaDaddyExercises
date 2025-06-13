package com.bichpormak;

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);

}
