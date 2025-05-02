package com.bichpormak;

public class PairDemo {

    public static void main(String[] args) {

        final Pair<String, Integer> pair1 = new Pair<>("Abobus", 3);

        System.out.println(pair1);

        pair1.setFirst("Abobus2");
        pair1.setSecond(4);

        System.out.println(pair1);

    }

}
