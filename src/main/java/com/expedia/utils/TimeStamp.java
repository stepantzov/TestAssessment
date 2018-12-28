package com.expedia.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp {
    public static String getDateFormatted(int daysAfter) {
        Date currentDate = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, daysAfter);

        return new SimpleDateFormat("MM-dd-YYYY").format(calendar.getTime());
    }
}