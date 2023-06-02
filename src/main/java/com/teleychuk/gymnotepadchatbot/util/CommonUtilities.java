package com.teleychuk.gymnotepadchatbot.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtilities {

    public static String dayOnKeyboardForAnswer(Day day) {
        DateTimeFormatter europeanFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.of(1990,1,1);
        if (day.equals(Day.TODAY)) {
            date = LocalDate.now();
        } if (day.equals(Day.YESTERDAY)) {
            date = LocalDate.now().minusDays(1);
        }
        if (day.equals(Day.DAY_BEFORE_YESTERDAY)) {
            date = LocalDate.now().minusDays(2);
        }
        return europeanFormat.format(date);
    }

    public static LocalDate dayOnKeyboardForSystem(Day day) {
        LocalDate date = LocalDate.of(1990,1,1);
        if (day.equals(Day.TODAY)) {
            date = LocalDate.now();
        } if (day.equals(Day.YESTERDAY)) {
            date = LocalDate.now().minusDays(1);
        }
        if (day.equals(Day.DAY_BEFORE_YESTERDAY)) {
            date = LocalDate.now().minusDays(2);
        }
        return date;
    }
}

