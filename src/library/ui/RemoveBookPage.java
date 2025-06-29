// src/library/ui/RemoveBookPage.java
package library.ui;

import library.controller.BookController;

import java.util.Scanner;

public class RemoveBookPage {
    private final BookController ctrl;

    public RemoveBookPage(BookController ctrl) {
        this.ctrl = ctrl;
    }

    public void run(Scanner sc) {
        System.out.print("Book ID to remove: ");
        String id = sc.nextLine();

        ctrl.removeBook(id);
        System.out.println("🗑️ Book removed (if it existed)\n");
    }
}