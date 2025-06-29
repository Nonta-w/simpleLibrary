// src/library/ui/BorrowBookPage.java
package library.ui;

import library.controller.LoanController;
import library.model.Loan;

import java.util.Scanner;

public class BorrowBookPage {
    private final LoanController ctrl;

    public BorrowBookPage(LoanController ctrl) {
        this.ctrl = ctrl;
    }

    public void run(Scanner sc) {
        System.out.print("Book ID to borrow: ");
        String id = sc.nextLine();

        try {
            Loan loan = ctrl.borrowBook(id);
            System.out.println("📚 Borrowed! Loan id = " + loan.getId() + "\n");
        } catch (RuntimeException ex) {
            System.out.println("❌ " + ex.getMessage() + "\n");
        }
    }
}