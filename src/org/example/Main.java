package org.example;

import org.example.model.*;
import org.example.service.BookService;
import org.example.service.InvoiceService;
import org.example.service.LoanService;
import org.example.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookService bookService = new BookService();
        UserService userService = new UserService();
        LoanService loanService = new LoanService();
        InvoiceService invoiceService = new InvoiceService();

        System.out.println("Kütüphane otomasyonuna hoş geldiniz");

        while (true) {
            System.out.println("--- MENÜ ---");
            System.out.println("1. Kullanıcı ekle");
            System.out.println("2. Kitap ekle");
            System.out.println("3. Kitap ödünç al");
            System.out.println("4. Kitap iade et");
            System.out.println("5. Kitapları listele");
            System.out.println("6. Kullanıcıları listele");
            System.out.println("7. Faturaları görüntüle");
            System.out.println("0. Çıkış");
            System.out.println("Seçiminiz: ");

            int secim = Integer.parseInt(scanner.nextLine());

            switch (secim) {
                case 1 -> {
                    System.out.println("Kullanıcı adı: ");
                    String name = scanner.nextLine();

                    System.out.println("Kullanıcı  tipi seçin:");
                    System.out.println("1. Öğrenci");
                    System.out.println("2. Personel");
                    int tip = Integer.parseInt(scanner.nextLine());

                    if(tip == 1){
                        userService.addUser(new StudentUser(name));
                    } else if (tip == 2) {
                        userService.addUser(new StaffUser(name));
                    } else {
                        System.out.println("Geçersiz kullanıcı tipi.");
                    }
                }

                case 2 -> {
                    System.out.println("Kitap adı: ");
                    String title = scanner.nextLine();
                    System.out.println("Yazar adı: ");
                    String authorName = scanner.nextLine();
                    System.out.println("Kategori: ");
                    String categoryName = scanner.nextLine();

                    Book book = new Book(title, new Author(authorName), new Category(categoryName));
                    bookService.addBook(book);
                }

                case 3 -> {
                    System.out.println("Kullanıcı ID: ");
                    int userId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Kitap ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());

                    User user = userService.getUserById(userId);
                    Book book = bookService.getBookById(bookId);

                    if(user != null && book !=null){
                        loanService.borrowBook(user, book);
                    } else {
                        System.out.println("Geçersiz kullanıcı veya kitap ID");
                    }
                }

                case 4 -> {
                    System.out.println("Kullanıcı ID: ");
                    int userId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Kitap ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());

                    User user = userService.getUserById(userId);
                    Book book = bookService.getBookById(bookId);

                    if(user != null && book !=null){
                        loanService.returnBook(user, book, invoiceService);
                    } else {
                        System.out.println("Geçersiz kullanıcı veya kitap ID");
                    }
                }

                case 5 -> bookService.printAllBooks();
                case 6 -> userService.printAllUsers();
                case 7 -> invoiceService.printAllInvoices();

                case 0 -> {
                    System.out.println("Çıkış yapıldı. İyi okumalar!");
                    return;
                }

                default -> System.out.println("Geçersiz seçim");

            }
        }
    }
}