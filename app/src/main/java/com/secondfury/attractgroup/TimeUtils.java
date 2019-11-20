package com.secondfury.attractgroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class TimeUtils {
    public static String prepareTimeForList(long timeMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy HH:mm", Locale.getDefault());
        return sdf.format(new Date(timeMillis));
    }
}
