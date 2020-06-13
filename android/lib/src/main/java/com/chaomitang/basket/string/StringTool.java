package com.chaomitang.basket.string;


import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {

    /**
     * Judge if the string is a number or not
     * @param s
     * @return true if a number string
     */
    public static boolean isNumeric(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        return isNum.matches();
    }

    /**
     * Get time format 00:00:00 from time seconds.
     * @param seconds
     * @return
     */
    public static String getFormatTimeString(long seconds) {
        String time;
        if (seconds < 60) {
            time = String.format(Locale.CANADA, "00:00:%02d", seconds % 60);

        } else if (seconds < 3600) {
            time = String.format(Locale.CANADA, "00:%02d:%02d", seconds / 60, seconds % 60);

        } else {
            time = String.format(Locale.CANADA, "%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);

        }
        return time;
    }
}
