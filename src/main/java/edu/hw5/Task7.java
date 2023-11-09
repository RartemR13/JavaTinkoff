package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task7 {
    private Task7() {
    }

    public static boolean check1(String str) {
        Pattern pattern = Pattern.compile("[01]{2,}0[01]*");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean check2(String str) {
        Pattern pattern = Pattern.compile("0.*0|1.*1|0|1");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean check3(String str) {
        Pattern pattern = Pattern.compile("[01]{1,3}");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
