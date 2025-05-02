package com.bichpormak;

public class BoxDemo {

    public static void main(String[] args) {

        final Box<String> box = new Box<>();

        box.setElement("Salo");

        System.out.println(box.getElement());

    }

}