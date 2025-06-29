// src/library/service/RemoveBookService.java
package library.service;

import library.dao.BookDAO;
import library.util.Logger;

public class RemoveBookService {
    private final BookDAO dao;

    public RemoveBookService(BookDAO dao) {
        this.dao = dao;
    }

    public void remove(String bookId) {
        dao.delete(bookId);
        Logger.info("Removed book id=" + bookId);
    }
}