package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MultipleStringLiterals")
public final class Task5 {
    private Task5() {
    }

    static Pattern pattern = Pattern.compile(
        "[АВЕКМНОРСТУХD]"
            + "\\d\\d\\d"
            + "[АВЕКМНОРСТУХD]"
            + "[АВЕКМНОРСТУХD]"
            + "\\d\\d\\d");

    public static boolean checkCaRNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
