package com.bichpormak.model;

import java.util.Arrays;

public class Food implements MenuItem {

    private String name;
    private double price;

    public Food(String name) {

        this.name = name;
        this.price = Arrays.stream(Menu.values())
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not on the menu"))
                .getPrice();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
