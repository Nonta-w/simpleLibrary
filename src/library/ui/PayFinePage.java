// src/library/ui/PayFinePage.java
package library.ui;

import library.controller.FineController;
import library.model.Fine;

import java.util.Collection;
import java.util.Scanner;

public class PayFinePage {
    private final FineController ctrl;

    public PayFinePage(FineController ctrl) {
        this.ctrl = ctrl;
    }

    public void run(Scanner sc) {
        Collection<Fine> unpaid = ctrl.listUnpaidFines();
        if (unpaid.isEmpty()) {
            System.out.println("🎉 No unpaid fines\n");
            return;
        }

        System.out.println("== Unpaid Fines ==");
        unpaid.forEach(f -> System.out.printf("• id=%s | member=%s | amount=%.2f%n",
                f.getId(), f.getMember().getName(), f.getAmount()));
        System.out.println();

        System.out.print("Fine ID to pay: ");
        String id = sc.nextLine();
        System.out.print("Amount to pay (THB): ");
        double amt = Double.parseDouble(sc.nextLine());

        try {
            ctrl.payFine(id, amt);
            System.out.println("💸 Fine settled\n");
        } catch (RuntimeException ex) {
            System.out.println("❌ " + ex.getMessage() + "\n");
        }
    }
}