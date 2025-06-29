// src/library/model/Fine.java
package library.model;

import java.util.UUID;

public class Fine {
    private final String id = UUID.randomUUID().toString();
    private final Member member;
    private double amount;
    private boolean paid = false;

    public Fine(Member member, double amount) {
        this.member = member;
        this.amount = amount;
    }

    /* ---------- getters / setters ---------- */
    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}