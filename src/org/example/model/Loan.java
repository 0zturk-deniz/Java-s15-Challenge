package org.example.model;

import java.time.LocalDate;

public class Loan {
    private static int loanCounter = 1;

    private final int loanId;
    private final User user;
    private final Book book;
    private final LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public Loan(User user, Book book) {
        this.loanId = loanCounter++;
        this.user = user;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.isReturned = false;
    }

    public int getLoanId() {
        return loanId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

   public void markAsReturned() {
        this.returnDate = LocalDate.now();
        this.isReturned = true;
   }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", user=" + user +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + (isReturned ? returnDate : "Not yet returned") +
                '}';
    }
}
