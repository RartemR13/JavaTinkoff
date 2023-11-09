package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public final class DaysAgoDateHandler extends DateHandler {
    @Override
    public Optional<LocalDate> handleRequest(String request) {
        String[] splited = request.split(" days ago");
        boolean correct = true;

        int days = 0;
        if (splited.length == 1) {
            try {
                days = Integer.parseInt(splited[0]);
            } catch (Exception any) {
                correct = false;
            }
        } else {
            correct = false;
        }

        Optional<LocalDate> res = Optional.of(LocalDate.now());

        if (!correct) {
            if (next != null) {
                res = next.handleRequest(request);
            } else {
                res = Optional.empty();
            }
        } else {
            res = Optional.of(res.get().minusDays(days));
        }

        return res;
    }
}
