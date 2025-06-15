package com.bichpormak.service;

import com.bichpormak.model.Menu;
import com.bichpormak.model.MenuItem;
import com.bichpormak.model.Order;

import java.util.Arrays;

public class OrderService {

    private Order order;

    public OrderService(Order order) {
        this.order = order;
    }

    public void addItem(MenuItem item) {

        String name = item.getName();

        Arrays.stream(Menu.values())
                .filter(dish -> dish.name().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(dish -> order.addItem(item));
    }

    public double getTotalPrice() {
        double price = order.getPrice();
        double discount = 0;

        if (price > 1000) {
            discount = applyDiscount(price);
        }

        return price - discount;
    }

    private double applyDiscount(double price) {
        return price / 100;
    }

    public void getListOfOrderItems() {

        if (order.getMenuItems().isEmpty()) {
            throw new IllegalStateException("No items in order");
        } else {
            System.out.println(order.getMenuItems());
        }

    }

}
