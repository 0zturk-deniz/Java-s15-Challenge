package org.example.service;

import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private final List<Loan> loanHistory = new ArrayList<>();

    public boolean borrowBook(User user, Book book) {
        if (!user.canBorrow()) {
            System.out.println("Kullanıcı kitap limitine ulaştı.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Kitap şu an başka bir kullanıcıda.");
            return false;
        }

        boolean success = user.borrowBook(book);
        if(success) {
            Loan loan = new Loan(user, book);
            loanHistory.add(loan);
            System.out.println("Kitap ödünç verildi. Loan ID: " + loan.getLoanId());
            return true;
        }

        return false;
    }

    public boolean returnBook(User user, Book book, InvoiceService invoiceService) {
        boolean success = user.returnBook(book);

        if(success) {
            for(Loan loan : loanHistory) {
                if(loan.getUser().equals(user) &&
                loan.getBook().equals(book) &&
                !loan.isReturned()) {
                    loan.markAsReturned();
                    System.out.println("Kitap iade edildi. Loan ID: " + loan.getLoanId());

                    long daysLate = calculateDaysLate(loan, 14);

                    if(daysLate > 0) {
                        invoiceService.penaltyInvoice(user, book, daysLate);
                    } else {
                        System.out.println("Kitap teslim süresi içinde iade edildi.");
                    }
                    return true;
                }
            }

            System.out.println("Kitap iade edildi.");
            return true;
        }

        System.out.println("Kitap iade işlemi başarısız oldu. Kitap kullanıcı kayıtlarında görünmüyor.");
        return false;
    }

    public long calculateDaysLate(Loan loan, int allowedDays) {
        if (!loan.isReturned()) return 0;

        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(
                loan.getBorrowDate(),
                loan.getReturnDate()
        );

        return Math.max(0, daysBetween - allowedDays);
    }

    public void printLoanHistory() {
        System.out.println("***Ödünç Alma Geçmişi***");
        for (Loan loan : loanHistory) {
            System.out.println(loan);
        }
    }
    public List<Loan> getLoanHistory() {
        return loanHistory;
    }
}
