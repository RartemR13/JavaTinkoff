package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class TodayDateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        if ("today".equalsIgnoreCase(request)) {
            LocalDate curDate = LocalDate.now();
            return Optional.of(curDate);
        }

        if (next != null) {
            return next.handleRequest(request);
        }

        return Optional.empty();
    }
}
