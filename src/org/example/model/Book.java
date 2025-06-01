package org.example.model;

public class Book {
    private static int idCounter = 1;

    private final int id;
    private String title;
    private Author author;
    private Category category;
    private boolean isAvailable;

    public Book(String title, Author author, Category category) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category =category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
