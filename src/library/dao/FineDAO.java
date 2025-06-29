//  src/library/dao/FineDAO.java
package library.dao;

import library.model.Fine;
import library.util.Database;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Simple in-memory data‐access object for Fine records.
 */
public class FineDAO {

    /** Persist or overwrite a fine. */
    public Fine save(Fine fine) {
        Database.fines.put(fine.getId(), fine);
        return fine;
    }

    /** Retrieve a fine by its ID (null if absent). */
    public Fine find(String id) {
        return Database.fines.get(id);
    }

    /** Delete a fine record. */
    public void delete(String id) {
        Database.fines.remove(id);
    }

    /** All fines currently stored. */
    public Collection<Fine> findAll() {
        return Database.fines.values();
    }

    /** Helpers to query unpaid fines or by member. */
    public Stream<Fine> unpaid() {
        return Database.fines.values().stream()
                .filter(f -> !f.isPaid());
    }

    public Stream<Fine> byMember(String memberId) {
        return Database.fines.values().stream()
                .filter(f -> f.getMember().getId().equals(memberId));
    }
}