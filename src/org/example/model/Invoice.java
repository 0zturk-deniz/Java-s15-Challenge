package org.example.model;

import java.time.LocalDate;

public class Invoice {
    private static int invoiceCounter = 1;

    private final int invoiceId;
    private final User user;
    private final Book book;
    private final double amount;
    private final LocalDate date;
    private boolean isRefunded;

    public Invoice(User user, Book book, double amount) {
        this.invoiceId = invoiceCounter++;
        this.user = user;
        this.book = book;
        this.amount = amount;
        this.date = LocalDate.now();
        this.isRefunded = false;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isRefunded() {
        return isRefunded;
    }

    public void refund() {
        this.isRefunded = true;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", user=" + user +
                ", book=" + book +
                ", amount=" + amount +
                ", date=" + date +
                ", isRefunded=" + isRefunded +
                '}';
    }
}
