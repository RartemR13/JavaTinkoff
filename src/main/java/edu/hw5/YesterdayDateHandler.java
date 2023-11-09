package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class YesterdayDateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        if ("yesterday".equalsIgnoreCase(request) || "1 day ago".equalsIgnoreCase(request)) {
            LocalDate curDate = LocalDate.now();
            return Optional.of(curDate.minusDays(1));
        }

        if (next != null) {
            return next.handleRequest(request);
        }

        return Optional.empty();
    }
}
