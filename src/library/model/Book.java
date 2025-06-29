// src/library/model/Book.java
package library.model;

import java.util.UUID;

public class Book {
    private final String id = UUID.randomUUID().toString();
    private String title;
    private String author;
    private boolean available = true;
    private boolean damaged = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /* ---------- getters / setters ---------- */
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }
}