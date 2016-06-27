package com.willen.openapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author willen
 *
 */
public final class DateUtil {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {
    }

    /**
     * 获取当前日期与时间
     */
    public static String getCurrentDateTime() {
        return dateTimeFormat.format(new Date());
    }
}
