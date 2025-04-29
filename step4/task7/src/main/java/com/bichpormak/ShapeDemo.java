package com.bichpormak;

public class ShapeDemo {

    public static void main(String[] args) {

        final Shape circle = new Circle(7);
        final Shape rectangle = new Rectangle(5, 3);


        System.out.println("Square: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        System.out.println("Square: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

    }

}