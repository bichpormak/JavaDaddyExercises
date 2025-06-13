package com.bichpormak.cli;

import com.bichpormak.enums.Command;
import com.bichpormak.model.Product;
import com.bichpormak.service.StoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.bichpormak.enums.Command.*;

public class StoreApp {
    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Футболка", 1000));
        catalog.add(new Product("Книга", 500));
        catalog.add(new Product("Кружка", 300));

        StoreService store = new StoreService(catalog);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            try {
                System.out.println("""
                \n
                Пиши \'catalog\' что бы посмотреть каталог
                Пиши \'add\' что бы добавить товар в корзину
                Пиши \'discount\' что бы применить скидку
                Пиши \'list\' что бы показать корзину
                Пиши \'exit\' что бы выйти
                """);
                String choice = scanner.nextLine();
                switch (Command.valueOf(choice.toUpperCase())) {
                    case CATALOG -> store.showCatalog();
                    case ADD -> {
                        System.out.print("Введите название товара: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите количество: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        store.addProductToCart(name, quantity);
                    }
                    case DISCOUNT -> {
                        System.out.print("Введите процент скидки: ");
                        double percent = Double.parseDouble(scanner.nextLine());
                        store.applyDiscount(percent);
                    }
                    case LIST -> store.printCart();
                    case EXIT -> running = false;
                    default -> System.out.println("Неверный ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Необработанная ошибка");
            }

        }
        scanner.close();
        System.out.println("Спасибо за покупки!");
    }
}