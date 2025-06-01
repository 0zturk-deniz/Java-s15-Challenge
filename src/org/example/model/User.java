package org.example.model;

import java.util.*;

public abstract class User {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final Set<Book> borrowedBooks;

    public User(String name) {
        this.id = idCounter++;
        this.name = name;
        this.borrowedBooks = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < 5;
    }

    public boolean borrowBook(Book book) {
        if (canBorrow() && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public abstract String whoYouAre();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equalsIgnoreCase(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name.toLowerCase());
    }
}
