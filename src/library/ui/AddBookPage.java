// src/library/ui/AddBookPage.java
package library.ui;

import library.controller.BookController;
import library.model.Book;

import java.util.Scanner;

public class AddBookPage {
    private final BookController ctrl;

    public AddBookPage(BookController ctrl) {
        this.ctrl = ctrl;
    }

    public void run(Scanner sc) {
        System.out.print("Title : ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();

        Book b = ctrl.addBook(title, author);
        System.out.println("✅ Book added with id " + b.getId() + "\n");
    }
}