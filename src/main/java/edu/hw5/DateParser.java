package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class DateParser {
    private final DateHandler slashHandler = new Slash3DateHandler();
    private final DateHandler dashHandler = new Dash3DateHandler();
    private final DateHandler today = new TodayDateHandler();
    private final DateHandler yesterday = new YesterdayDateHandler();
    private final DateHandler tomorrow = new TomorrowDateHandler();
    private final DateHandler daysAgo = new DaysAgoDateHandler();

    public DateParser() {
        daysAgo.setNext(tomorrow);
        tomorrow.setNext(yesterday);
        yesterday.setNext(today);
        today.setNext(dashHandler);
        dashHandler.setNext(slashHandler);
    }

    Optional<LocalDate> parseDate(String date) {
        return daysAgo.handleRequest(date);
    }
}
