package com.bichpormak.model;

import com.bichpormak.enums.PromotionalCode;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> items = new ArrayList<>();
    private PromotionalCode promotionalCode;
    private double discountPercent = 0.0;

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscount(double percent) {
        this.discountPercent = percent;
    }
}