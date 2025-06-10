package com.bichpormak;

public class PalindromeChecker {

    public static boolean isPalindrome(String text) {

        if (text == null) {
            return false;
        }

        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);

    }

}