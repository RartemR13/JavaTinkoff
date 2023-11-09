package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

@SuppressWarnings("MagicNumber")
public final class Task2 {
    private Task2() {
    }

    static TemporalAdjuster next13Friday = TemporalAdjusters.ofDateAdjuster(date -> {
        var curDate = date;

        while (curDate.getDayOfWeek() != DayOfWeek.FRIDAY || curDate.getDayOfMonth() != 13) {
            curDate = curDate.plusDays(1);
        }

        return curDate;
    });

    public static ArrayList<String> getAll13Fridays(int year) {
        LocalDate curDate = LocalDate.of(year, 1, 1);

        curDate = curDate.with(next13Friday);

        ArrayList<String> res = new ArrayList<>();

        while (curDate.getYear() == year) {
            res.add(curDate.toString());
            curDate = curDate
                .plus(Period.ofDays(1))
                .with(next13Friday);
        }

        return res;
    }
}
