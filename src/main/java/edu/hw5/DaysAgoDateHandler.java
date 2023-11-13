package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class DaysAgoDateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        String[] splited = request.split(" days ago");

        int days = 0;
        if (splited.length == 1) {
            try {
                days = Integer.parseInt(splited[0]);
            } catch (Exception any) {
                return (next != null) ? next.handleRequest(request) : Optional.empty();
            }
        }

        return Optional.of(LocalDate.now().minusDays(days));
    }
}
