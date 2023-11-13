package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateHandler {
    protected DateHandler next;

    public void setNext(DateHandler next) {
        this.next = next;
    }

    public abstract Optional<LocalDate> handleRequest(String request);
}
