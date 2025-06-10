package com.bichpormak.repository;

import com.bichpormak.Order;

public class OrderRepository {

    public void saveOrder(Order order) {
        // Заглушка для сохранения заказа в БД
        System.out.println("Заказ сохранен: " + order.getProductId());
    }

}