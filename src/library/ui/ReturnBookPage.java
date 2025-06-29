// src/library/ui/ReturnBookPage.java
package library.ui;

import library.controller.LoanController;

import java.util.Scanner;

public class ReturnBookPage {
    private final LoanController ctrl;

    public ReturnBookPage(LoanController ctrl) {
        this.ctrl = ctrl;
    }

    public void run(Scanner sc) {
        System.out.print("Loan ID to return: ");
        String loanId = sc.nextLine();

        System.out.print("Is the book damaged? (y/N): ");
        boolean damaged = sc.nextLine().trim().equalsIgnoreCase("y");

        try {
            ctrl.returnBook(loanId, damaged);
            System.out.println("↩️ Book returned" +
                    (damaged ? " (damage reported, fine issued)" : "") + "\n");
        } catch (RuntimeException ex) {
            System.out.println("❌ " + ex.getMessage() + "\n");
        }
    }
}