// src/library/service/AddBookService.java
package library.service;

import library.dao.BookDAO;
import library.model.Book;
import library.util.Logger;

public class AddBookService {
    private final BookDAO dao;

    public AddBookService(BookDAO dao) {
        this.dao = dao;
    }

    public Book add(String title, String author) {
        Book book = new Book(title, author);
        dao.save(book);
        Logger.info("Added book '" + title + "'");
        return book;
    }
}