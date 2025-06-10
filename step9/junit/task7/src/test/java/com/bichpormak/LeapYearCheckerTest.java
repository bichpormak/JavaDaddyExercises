package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeapYearCheckerTest {

    @Test
    @DisplayName("Year multiple of 4")
    public void givenYearMultipleOfFour_whenCheckForLeapYear_thenReturnTrue() {

        assertTrue(LeapYearChecker.isLeapYear(2032));

    }

    @Test
    @DisplayName("Year multiple of 100, but not multiple of 400")
    public void givenDoNotLeapYear_whenCheckForLeapYear_thenReturnFalse() {

        assertFalse(LeapYearChecker.isLeapYear(1900));

    }

    @Test
    @DisplayName("Year multiple of 400")
    public void givenYearMultipleOfFourHundred_whenCheckForLeapYear_thenReturnTrue() {

        assertAll(
                () -> assertTrue(LeapYearChecker.isLeapYear(2000)),
                () -> assertFalse(LeapYearChecker.isLeapYear(1800)) // multiple of 100
        );

    }

}
