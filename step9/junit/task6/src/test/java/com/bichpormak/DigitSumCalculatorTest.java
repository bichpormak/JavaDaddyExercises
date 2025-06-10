package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumCalculatorTest {

    @Test
    @DisplayName("Multi digit number")
    public void givenMultiDigitNumber_whenCountSumOfNumber_thenReturnCorrectAnswer() {

        assertEquals(12, DigitSumCalculator.sumDigits(912));

    }

    @Test
    @DisplayName("Single digit number")
    public void givenSingleDigitNumber_whenCountSumOfNumber_thenReturnCorrectAnswer() {

        assertEquals(0, DigitSumCalculator.sumDigits(0));

    }

    @Test
    @DisplayName("Negative number")
    public void givenNegativeNumber_whenCountSumOfNumber_thenReturnCorrectAnswer() {

        assertEquals(7, DigitSumCalculator.sumDigits(-34));

    }



}
