// src/library/service/ReturnBookService.java
package library.service;

import library.dao.*;
import library.model.*;
import library.util.Logger;
import java.time.LocalDate;

public class ReturnBookService {
    private final LoanDAO loanDAO;
    private final FineDAO fineDAO;

    public ReturnBookService(LoanDAO lDao, FineDAO fDao) {
        this.loanDAO = lDao;
        this.fineDAO = fDao;
    }

    public void returnBook(String loanId, boolean damaged) {
        Loan loan = loanDAO.find(loanId);
        if (loan == null)
            throw new IllegalArgumentException("Invalid loan id");

        Book book = loan.getBook();
        book.setAvailable(true);
        loan.setReturnDate(LocalDate.now());
        loan.setDamageReported(damaged);

        if (damaged) {
            Fine fine = new Fine(loan.getMember(), 100.0);
            fineDAO.save(fine);
            Logger.info("Damage fine issued: 100.0 THB");
        }
        Logger.info("Book returned: " + book.getTitle());
    }
}