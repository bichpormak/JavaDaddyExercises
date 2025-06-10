package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {

    @Test
    @DisplayName("Common palindrome")
    public void givenCommonPalindrome_whenCheckStringForPalindrome_thenReturnTrue() {

        assertTrue(PalindromeChecker.isPalindrome("madam"));

    }

    @Test
    @DisplayName("Not a palindrome")
    public void givenStringIsNotPalindrome_whenCheckStringForPalindrome_thenReturnFalse() {

        assertFalse(PalindromeChecker.isPalindrome("abobus"));

    }

    @Test
    @DisplayName("String is null")
    public void givenNullString_whenCheckStringForPalindrome_thenReturnFalse() {

        assertFalse(PalindromeChecker.isPalindrome(null));

    }

    @Test
    @DisplayName("Empty string")
    public void givenEmptyString_whenCheckStringForPalindrome_thenReturnTrue() {

        assertTrue(PalindromeChecker.isPalindrome(""));

    }

    @Test
    @DisplayName("String(palindrome) with spaces")
    public void givenStringWithSpaces_whenCheckStringForPalindrome_thenReturnCorrectAnswer() {

        assertTrue(PalindromeChecker.isPalindrome("Abobus   suboba"));

    }

    @Test
    @DisplayName("Letters with different cases")
    public void givenPalindromeString_whenCheckStringForPalindrome_thenReturnCorrectAnswer() {

        assertTrue(PalindromeChecker.isPalindrome("AboBusuboba"));

    }
}
