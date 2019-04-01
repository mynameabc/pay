package com.utils;

import java.util.Date;

public class DateUtil {

    /**
     * 加分钟数
     * @param minute
     * @return
     */
    public static Date getDate(Date now, int minute) {
        return new Date(now.getTime() + 60 * 1000 * minute);
    }
}
