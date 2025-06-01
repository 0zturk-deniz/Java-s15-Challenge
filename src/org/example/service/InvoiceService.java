package org.example.service;

import org.example.model.Book;
import org.example.model.Invoice;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private final List<Invoice> invoices = new ArrayList<>();
    private final double penaltyPerDay = 25.0;

    public Invoice penaltyInvoice(User user, Book book, long daysLate) {
        double amount = daysLate * penaltyPerDay;
        Invoice invoice = new Invoice(user, book, amount);
        invoices.add(invoice);
        System.out.println("GEÇ TESLİM FATURASI OLUŞTURULDU: " + invoice);
        return invoice;
    }

    public void printAllInvoices() {
        System.out.println("Tüm Faturalar:");
        for(Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
