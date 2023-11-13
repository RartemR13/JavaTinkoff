package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task7 {
    private Task7() {
    }

    static Pattern pattern1 = Pattern.compile("[01]{2,}0[01]*");
    static Pattern pattern2 = Pattern.compile("0.*0|1.*1|0|1");
    static Pattern pattern3 = Pattern.compile("[01]{1,3}");

    public static boolean check1(String str) {
        Matcher matcher = pattern1.matcher(str);

        return matcher.matches();
    }

    public static boolean check2(String str) {
        Matcher matcher = pattern2.matcher(str);

        return matcher.matches();
    }

    public static boolean check3(String str) {
        Matcher matcher = pattern3.matcher(str);

        return matcher.matches();
    }
}
