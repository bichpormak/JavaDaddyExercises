package com.bichpormak;

public enum Planet {

    EARTH(5, 3),
    MARS(5, 7),
    JUPITER(3, 10);

    private final double mass;
    private final double radius;
    private static final double GRAVITY = 6.67430e-11;


    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        return GRAVITY * mass / (radius * radius);
    }


}
