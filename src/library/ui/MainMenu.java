// src/library/ui/MainMenu.java
package library.ui;

import library.controller.*;
import library.dao.*;
import library.model.Member;

import java.util.Scanner;

public class MainMenu {
    private final BookController bookCtrl;
    private final LoanController loanCtrl;
    private final FineController fineCtrl;
    private final Member defaultMember = new Member("Test User");

    public MainMenu() {
        BookDAO bDao = new BookDAO();
        LoanDAO lDao = new LoanDAO();
        FineDAO fDao = new FineDAO();
        bookCtrl = new BookController(bDao);
        loanCtrl = new LoanController(bDao, lDao, fDao, defaultMember);
        fineCtrl = new FineController(fDao);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    === Library Menu ===
                    1) Add Book
                    2) Remove Book
                    3) Borrow Book
                    4) Return Book
                    5) Pay Fine
                    0) Exit
                    """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> new AddBookPage(bookCtrl).run(sc);
                case 2 -> new RemoveBookPage(bookCtrl).run(sc);
                case 3 -> new BorrowBookPage(loanCtrl).run(sc);
                case 4 -> new ReturnBookPage(loanCtrl).run(sc);
                case 5 -> new PayFinePage(fineCtrl).run(sc);
                case 0 -> {
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu().run();
    }
}