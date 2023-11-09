package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        DateParser parser = new DateParser();
        return parser.parseDate(date);
    }
}
