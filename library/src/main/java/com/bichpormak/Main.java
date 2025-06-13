package com.bichpormak;

import com.bichpormak.enums.Command;
import com.bichpormak.model.Book;
import com.bichpormak.service.Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            try {
                System.out.println("""
                        \n
                        Write \'add\' for add Book
                        Write \'remove\' for Remove Book
                        Write \'find\' for Search Book
                        Write \'list\' for List All Books
                        Write \'exit\' for Exit
                        """);
                String choice = scanner.nextLine();

                switch (Command.valueOf(choice.toUpperCase())) {
                    case ADD -> {
                        System.out.println("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.println("Enter year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        library.addBook(new Book(title, author, genre, year));
                    }
                    case REMOVE -> {
                        System.out.println("Enter title: ");
                        String titleToRemove = scanner.nextLine();
                        library.removeBook(titleToRemove);
                    }
                    case FIND -> {
                        System.out.println("Enter title to search: ");
                        String searchTitle = scanner.nextLine();
                        List<Book> results = library.searchByTitle(searchTitle);
                        results.forEach(System.out::println);
                    }
                    case LIST -> library.listBooks().forEach(System.out::println);
                    case EXIT -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Unrecognized command");
            }
        }
        scanner.close();
    }
}