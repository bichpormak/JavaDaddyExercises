package com.bichpormak;

public class StringModifierDemo {

    public static void main(String[] args) {

        StringModifier stringModifier = s -> s.toUpperCase() + "!";

        System.out.println(stringModifier.modify("abobus"));

    }

}