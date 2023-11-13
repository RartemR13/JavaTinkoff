package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SuppressWarnings("MagicNumber")
public final class Slash3DateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        Optional<LocalDate> ret;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/uuuu");
            ret = Optional.of(LocalDate.parse(request, formatter));
        } catch (Exception any) {
            return (next != null) ? next.handleRequest(request) : Optional.empty();
        }

        return ret;
    }
}
