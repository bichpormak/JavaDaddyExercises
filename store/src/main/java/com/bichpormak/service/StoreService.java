package com.bichpormak.service;

import com.bichpormak.model.Cart;
import com.bichpormak.model.CartItem;
import com.bichpormak.model.Product;

import java.util.List;
import java.util.function.Function;

public class StoreService {
    private final List<Product> catalog;
    private final Cart cart;

    public StoreService(List<Product> catalog) {
        this.catalog = catalog;
        this.cart = new Cart();
    }

    public void showCatalog() {
        for (Product p : catalog) {
            System.out.println(p.name() + " - " + p.price() + " руб.");
        }
    }

    public void addProductToCart(String name, int quantity) {
        for (Product p : catalog) {
            if (p.name().equalsIgnoreCase(name) && quantity > 0) {

                cart.getItems().stream()
                        .filter(o1 -> o1.getProduct().name().equalsIgnoreCase(name))
                        .findFirst()
                        .ifPresentOrElse(o1 -> o1.setQuantity(o1.getQuantity() + quantity), () -> cart.addItem(p, quantity));


                System.out.println("Добавлено: " + name + " x" + quantity);
                return;
            }
        }
        System.out.println("Товар не найден: " + name);
    }

    public void applyDiscount(double percent) {
        cart.setDiscount(percent);
    }

    public void printCart() {
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getProduct().name() + " x" + item.getQuantity() + " = " + item.getTotalPrice());
        }
        System.out.println("Итого со скидкой: " + calculateTotal());
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            total += item.getTotalPrice();
        }
        double discountAmount = total * cart.getDiscountPercent() / 100;

        if (discountAmount >= total) {
            return 0;
        }

        return total - discountAmount;
    }
}