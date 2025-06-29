// src/library/service/BorrowBookService.java
package library.service;

import library.dao.*;
import library.model.*;
import library.util.Logger;

public class BorrowBookService {
    private final BookDAO bookDAO;
    private final LoanDAO loanDAO;

    public BorrowBookService(BookDAO bDao, LoanDAO lDao) {
        this.bookDAO = bDao;
        this.loanDAO = lDao;
    }

    public Loan borrow(String bookId, Member member) {
        Book book = bookDAO.find(bookId);
        if (book == null || !book.isAvailable())
            throw new IllegalStateException("Book unavailable");
        book.setAvailable(false);
        Loan loan = new Loan(book, member);
        loanDAO.save(loan);
        Logger.info("Borrowed book '" + book.getTitle() + "' by " + member.getName());
        return loan;
    }
}