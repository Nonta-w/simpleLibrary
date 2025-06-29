// src/library/controller/BookController.java
package library.controller;

import library.service.*;
import library.dao.BookDAO;
import library.model.Book;

public class BookController {
    private final AddBookService addSvc;
    private final RemoveBookService remSvc;

    public BookController(BookDAO dao) {
        this.addSvc = new AddBookService(dao);
        this.remSvc = new RemoveBookService(dao);
    }

    public Book addBook(String t, String a) {
        return addSvc.add(t, a);
    }

    public void removeBook(String id) {
        remSvc.remove(id);
    }
}