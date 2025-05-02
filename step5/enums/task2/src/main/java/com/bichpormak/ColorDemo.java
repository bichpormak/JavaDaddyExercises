package com.bichpormak;

public class ColorDemo {

    public static void main(String[] args) {

        for (Color color : Color.values()) {
            System.out.println(color + " " + color.getHexCode());
        }

    }

}