// src/library/util/Logger.java
package library.util;

public final class Logger {
    public static void info(String msg) {
        System.out.println("[INFO]  " + msg);
    }

    public static void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }
}