// src/library/model/Loan.java
package library.model;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private final String id = UUID.randomUUID().toString();
    private final Book book;
    private final Member member;
    private final LocalDate borrowDate = LocalDate.now();
    private LocalDate returnDate;
    private boolean damageReported = false;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    /* ---------- getters / setters ---------- */
    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }

    public boolean isDamageReported() {
        return damageReported;
    }

    public void setDamageReported(boolean flag) {
        this.damageReported = flag;
    }
}