package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean isSubstring(String big, String little) {
        Pattern pattern = Pattern.compile(".*" + little + ".*");
        Matcher matcher = pattern.matcher(big);

        return matcher.matches();
    }
}
