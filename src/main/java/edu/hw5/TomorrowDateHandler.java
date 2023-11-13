package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class TomorrowDateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        if ("tomorrow".equalsIgnoreCase(request)) {
            LocalDate curDate = LocalDate.now();
            return Optional.of(curDate.plusDays(1));
        }

        if (next != null) {
            return next.handleRequest(request);
        }

        return Optional.empty();
    }
}
