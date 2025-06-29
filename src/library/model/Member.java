// src/library/model/Member.java
package library.model;

import java.util.UUID;

public class Member {
    private final String id = UUID.randomUUID().toString();
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    /* ---------- getters ---------- */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}