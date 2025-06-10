package com.bichpormak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    @DisplayName("Plain sentence")
    public void givenSentence_whenSplitString_thenCountWords() {

        assertEquals(5, WordCounter.countWords("Abobus is a beautiful boy"));

    }

    @Test
    @DisplayName("String is null")
    public void givenStringNull_whenSplitString_thenReturnZero() {

        assertEquals(0, WordCounter.countWords(null));

    }

    @Test
    @DisplayName("A line with multiple spaces in a row")
    public void givenSentenceWithMultipleSpaces_whenSplitString_thenReturnCorrectCountWords() {

        assertEquals(2, WordCounter.countWords("Abobus    abobus"));
    }

    @Test
    @DisplayName("Text instead of sentence")
    public void givenText_whenSplitString_thenReturnCorrectCountWords() {

        String text = "     \tAbobus abobus" +
                " abobus....\n";

        assertEquals(3, WordCounter.countWords(text));

    }

    @Test
    @DisplayName("Empty string")
    public void givenEmptyString_whenSplitString_thenReturnCorrectCountWords() {

        assertEquals(0, WordCounter.countWords(""));

    }


}
