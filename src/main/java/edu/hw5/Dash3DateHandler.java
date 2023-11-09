package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

@SuppressWarnings("MagicNumber")
public final class Dash3DateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        String[] splited = request.split("-");
        Optional<LocalDate> ret = Optional.empty();

        boolean correct = true;

        if (splited.length != 3) {
            correct = false;
        } else {
            try {
                ret = Optional.of(LocalDate.of(
                    Integer.parseInt(splited[0]),
                    Integer.parseInt(splited[1]),
                    Integer.parseInt(splited[2])
                ));
            } catch (Exception any) {
                correct = false;
            }
        }

        if (!correct) {
            if (next != null) {
                ret = next.handleRequest(request);
            }
        }

        return ret;
    }
}
