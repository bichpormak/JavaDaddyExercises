package com.bichpormak.model;

public enum Menu {

    COFFEE("Coffe", 100),
    JUICE("Juice", 200),
    WATER("Water", 50),
    STEAK("Steak", 1000),
    PORRIDGE("Porridge", 500),
    CHICKEN("Chicken", 10000);

    private final String name;
    private final double price;

    Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
