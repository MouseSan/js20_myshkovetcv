package ru.tsystems.js20.myshkovetcv.service;

import java.util.Calendar;
import java.util.Date;

public class DateService {

    public static Date getDateMonthAgo() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());

        cal.setTime(date);
        if (date.getMonth() == 0) {
            cal.set(Calendar.YEAR, date.getYear() - 1);
            cal.set(Calendar.MONTH, 12);
        } else {
            cal.set(Calendar.MONTH, date.getMonth() - 1);
        }

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
