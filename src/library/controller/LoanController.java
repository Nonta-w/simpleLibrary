// src/library/controller/LoanController.java
package library.controller;

import library.dao.*;
import library.model.*;
import library.service.BorrowBookService;
import library.service.ReturnBookService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Orchestrates borrowing and returning books for a single “current” member.
 * UI pages call this controller; it delegates to the one-class-per-function
 * services.
 */
public class LoanController {

    private final BorrowBookService borrowSvc;
    private final ReturnBookService returnSvc;
    private final LoanDAO loanDAO;
    private final Member currentMember;

    /**
     * @param bookDAO DAO for book lookup/updates
     * @param loanDAO DAO for persisting loans
     * @param fineDAO DAO for fines (needed by ReturnBookService)
     * @param member  The member performing actions in the current session
     */
    public LoanController(BookDAO bookDAO,
            LoanDAO loanDAO,
            FineDAO fineDAO,
            Member member) {

        this.borrowSvc = new BorrowBookService(bookDAO, loanDAO);
        this.returnSvc = new ReturnBookService(loanDAO, fineDAO);
        this.loanDAO = loanDAO;
        this.currentMember = member;
    }

    /** Borrow a book and return the Loan record. */
    public Loan borrowBook(String bookId) {
        return borrowSvc.borrow(bookId, currentMember);
    }

    /** Return a book (optionally reporting damage). */
    public void returnBook(String loanId, boolean damaged) {
        returnSvc.returnBook(loanId, damaged);
    }

    /** Helper: list all active loans for the current member. */
    public Collection<Loan> listMyActiveLoans() {
        return loanDAO.byMember(currentMember.getId())
                .filter(l -> l.getReturnDate() == null)
                .collect(Collectors.toList());
    }
}