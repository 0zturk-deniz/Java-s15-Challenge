package org.example.service;

import org.example.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private final Map<Integer, Book> bookMap = new HashMap<>();

    public void addBook(Book book) {
        bookMap.put(book.getId(), book);
        System.out.println("Kitap kütüphane veritabanına eklendi: " + book);
    }

    public Book getBookById(int id) {
        return bookMap.get(id);
    }

    public List<Book> getBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> results = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> getBooksByCategory(String categoryName) {
        List<Book> results = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getCategory().getName().equalsIgnoreCase(categoryName)) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean deleteBook(int id) {
        if (bookMap.containsKey(id)) {
            Book removed = bookMap.remove(id);
            System.out.println("Kitap veritabanından silindi: " + removed);
            return true;
        }
        return false;
    }

    public void printAllBooks() {
        System.out.println("Tüm Kitaplar:");
        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
    }
}
