package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisionCalculatorTests {


    @Test
    @DisplayName("Division of two numbers")
    public void givenTwoNumbers_whenDivide_givenReturnCorrectAnswer() {

        double a = 5, b = 10;

        assertEquals(0.5, DivisionCalculator.divide(a, b));

    }

    @Test
    @DisplayName("Dividing infinity by infinity")
    public void givenTwoInfinity_whenDivide_givenReturnNan() {

        Double a = Double.POSITIVE_INFINITY;
        Double b = Double.POSITIVE_INFINITY;

        assertTrue(Double.isNaN(DivisionCalculator.divide(a, b)));

    }

    @Test
    @DisplayName("Division by 0")
    public void givenTwoNumbersOneOfWhichIsZero_whenDivide_givenReturnInfinity() {

        double a = 5, b = 0;

        assertTrue(Double.isInfinite(DivisionCalculator.divide(a, b)));

    }

}
