package com.bichpormak;

public class WordCounter {

    public static int countWords(String text) {

        if (text == null) {
            return 0;
        }

        String[] words = text.split(" ");

        int count = 0;
        for (String word : words) {

            if (!word.isEmpty()) {
                count++;
            }

        }

        return count;

    }

}