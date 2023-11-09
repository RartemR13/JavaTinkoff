package edu.hw5;

import java.time.Duration;
import java.time.Instant;

@SuppressWarnings("MagicNumber")
public final class Task1 {
    private Task1() {
    }

    private static String convertTimeFormat(String time) {
        var dateTime = time.split(", ");
        return dateTime[0] + "T" + dateTime[1] + ":00.000Z";
    }

    public static int averageTimeMinutes(String... stringSequence) {
        long res = 0;

        for (String cur : stringSequence) {
            var incorrectBeginEnd = cur.split(" - ");
            String[] beginEnd = new String[2];
            for (int i = 0; i < incorrectBeginEnd.length; ++i) {
                beginEnd[i] = convertTimeFormat(incorrectBeginEnd[i]);
            }

            res += Duration.between(Instant.parse(beginEnd[0]), Instant.parse(beginEnd[1])).getSeconds();
        }

        res /= 60L * stringSequence.length;

        return (int) res;
    }
}
