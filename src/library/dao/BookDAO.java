// src/library/dao/BookDAO.java
package library.dao;

import library.model.Book;
import library.util.Database;
import java.util.Collection;

public class BookDAO {
    public Book save(Book b) {
        Database.books.put(b.getId(), b);
        return b;
    }

    public Book find(String id) {
        return Database.books.get(id);
    }

    public void delete(String id) {
        Database.books.remove(id);
    }

    public Collection<Book> findAll() {
        return Database.books.values();
    }
}