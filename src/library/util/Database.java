// src/library/util/Database.java
package library.util;

import library.model.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class Database {
    public static final Map<String, Book> books = new ConcurrentHashMap<>();
    public static final Map<String, Loan> loans = new ConcurrentHashMap<>();
    public static final Map<String, Fine> fines = new ConcurrentHashMap<>();

    private Database() {
    } // static holder only
}