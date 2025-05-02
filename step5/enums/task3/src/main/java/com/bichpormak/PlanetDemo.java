package com.bichpormak;

public class PlanetDemo {

    public static void main(String[] args) {

        for (Planet planet : Planet.values()) {
            System.out.println(planet.surfaceGravity());
        }

    }

}