package com.bichpormak.service;

import com.bichpormak.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.title().equals(title));
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.title().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> getBooksOfAuthor(String author) {

        return books.stream()
                .filter(book -> book.author().equals(author))
                .toList();

    }

    public List<Book> getBooksOfGenre(String genre) {

        return books.stream()
                .filter(book -> book.genre().equals(genre))
                .toList();

    }

    public List<Book> getBooksOfYear(int year) {

        return books.stream()
                .filter(book -> book.year() == year)
                .toList();

    }

}