package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task8 {
    private Task8() {
    }

    static Pattern pattern1 = Pattern.compile("([01]{2})*[01]");
    static Pattern pattern2 = Pattern.compile("0([01]{2})*|1([01]{2})*[01]");
    static Pattern pattern3 = Pattern.compile("(1*01*01*01*)*");
    static Pattern pattern5 = Pattern.compile("((10)*|(11)*)*|((10)*|(11)*)*1");

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

    public static boolean check5(String str) {
        Matcher matcher = pattern5.matcher(str);

        return matcher.matches();
    }
}
