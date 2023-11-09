package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {
    private Task4() {
    }

    public static boolean pswHaveSpecial(String psw) {
        Pattern pattern = Pattern.compile("\\w*[~!@#$%^&*|]\\w*");
        Matcher matcher = pattern.matcher(psw);

        return matcher.matches();
    }
}
