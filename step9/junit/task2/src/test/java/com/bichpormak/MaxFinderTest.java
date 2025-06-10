package com.bichpormak;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxFinderTest {

    @Test
    @DisplayName("Find max number in empty array")
    public void givenEmptyArray_whenFindMaxNumber_givenReturnException() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> MaxFinder.findMax(new int[0]));

    }

    @Test
    @DisplayName("Max number in array with repeated numbers")
    public void givenArrayWithRepeatedNumbers_whenFindMaxNumber_givenReturnMaxNumber() {

        int[] a = {5, 5, 5, 5};

        assertEquals(5, MaxFinder.findMax(a));

    }

    @Test
    @DisplayName("Array with one element")
    public void givenArrayWithOneElement_whenFindMaxNumber_givenReturnMaxNumber() {

        int[] a = {5};

        assertEquals(5, MaxFinder.findMax(a));

    }

    @Test
    @DisplayName("Array with negative numbers")
    public void givenArrayWithNegativeNumbers_whenFindMaxNumber_givenReturnMaxNumber() {

        int[] a = {-1, -2, -7, -3};

        assertEquals(-1, MaxFinder.findMax(a));

    }



}
