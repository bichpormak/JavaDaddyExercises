package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    @DisplayName("Correct password")
    public void givenCorrectPassword_whenCheckPasswordValidator_thenReturnTrue() {

        assertTrue(PasswordValidator.isValid("abobuses1"));

    }

    @Test
    @DisplayName("Password without digits")
    public void givenPasswordWithoutDigits_whenCheckPasswordValidator_thenReturnFalse() {

        assertFalse(PasswordValidator.isValid("abobuses vau"));

    }

    @Test
    @DisplayName("Password less than 8 characters")
    public void givenShortPassword_whenCheckPasswordValidator_thenReturnFalse() {

        assertFalse(PasswordValidator.isValid("a"));

    }

    @Test
    @DisplayName("Password not entered")
    public void givenEmptyPassword_whenCheckPasswordValidator_thenReturnFalse() {

        assertFalse(PasswordValidator.isValid(""));

    }

    @Test
    @DisplayName("Instead of a password, null arrived")
    public void givenNullString_whenCheckPasswordValidator_thenReturnException() {

        assertFalse(PasswordValidator.isValid(null));

    }

}