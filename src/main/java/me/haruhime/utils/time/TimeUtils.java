package me.haruhime.utils.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getLogTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static String getClock() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        return sdfDate.format(now);
    }

}
