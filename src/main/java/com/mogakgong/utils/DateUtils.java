package com.mogakgong.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;

public class DateUtils {
    public static final String FORMAT_TODAY_DATE = convertLocalDateToDateFormat(LocalDate.now()); // 23/4/8(토)
    private static final int TWO_THOUSAND_YEAR = 2000;

    private DateUtils() {}

    private static String convertLocalDateToDateFormat(LocalDate localDate) {
        return String.format("%s/%s/%s(%s)",
                String.valueOf(localDate.getYear()).substring(2),
                localDate.getMonth().getValue(),
                localDate.getDayOfMonth(),
                localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREA)
        );
    }

    public static boolean isMatchDate(Matcher matcher) {
        if (matcher.find()) {
            String[] groups = matcher.group().split("월|일");
            LocalDate savedDate = makeLocalDateWithFile(groups[0], groups[1]);
            String convertSavedDate = convertLocalDateToDateFormat(savedDate);

            if(convertSavedDate.equals(FORMAT_TODAY_DATE)) {
                return true;
            }
        }
        return false;
    }

    private static LocalDate makeLocalDateWithFile(String month, String day) {
        return LocalDate.of(
                convertStringToInt(getThisYear(FORMAT_TODAY_DATE)),
                convertStringToInt(month),
                convertStringToInt(day)
        );
    }

    private static String getThisYear(String date) {
        return String.valueOf(TWO_THOUSAND_YEAR + Integer.parseInt(date.substring(0, 2)));
    }

    private static int convertStringToInt(String group) {
        return Integer.parseInt(group.trim());
    }
}
