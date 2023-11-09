package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task8 {
    private Task8() {
    }

    public static boolean check1(String str) {
        Pattern pattern = Pattern.compile("([01]{2})*[01]");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean check2(String str) {
        Pattern pattern = Pattern.compile("0([01]{2})*|1([01]{2})*[01]");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean check3(String str) {
        Pattern pattern = Pattern.compile("(1*01*01*01*)*");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean check5(String str) {
        Pattern pattern = Pattern.compile("((10)*|(11)*)*|((10)*|(11)*)*1");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

}
