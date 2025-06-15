package com.bichpormak.model;

import java.util.*;

public class Order {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public void addItem(MenuItem item) {

        menuItems.add(item);

    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public double getPrice() {
        return menuItems.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

}
