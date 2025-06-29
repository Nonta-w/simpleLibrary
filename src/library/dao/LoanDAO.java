//  src/library/dao/LoanDAO.java
package library.dao;

import library.model.Loan;
import library.util.Database;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Simple in-memory data‐access object for Loan records.
 */
public class LoanDAO {

    /** Persist or overwrite a loan. */
    public Loan save(Loan loan) {
        Database.loans.put(loan.getId(), loan);
        return loan;
    }

    /** Retrieve a loan by its ID (null if absent). */
    public Loan find(String id) {
        return Database.loans.get(id);
    }

    /** Delete a loan record. */
    public void delete(String id) {
        Database.loans.remove(id);
    }

    /** All loans currently stored. */
    public Collection<Loan> findAll() {
        return Database.loans.values();
    }

    /** Convenience helpers (optional) */
    public Stream<Loan> byMember(String memberId) {
        return Database.loans.values().stream()
                .filter(l -> l.getMember().getId().equals(memberId));
    }

    public Stream<Loan> active() {
        return Database.loans.values().stream()
                .filter(l -> l.getReturnDate() == null);
    }
}