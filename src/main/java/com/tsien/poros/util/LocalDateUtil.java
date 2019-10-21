package com.tsien.poros.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/26 0026 19:35
 */

public class LocalDateUtil {

    /**
     * 标准化日期格式
     */
    private static final String STANDARD_FORMAT = "yyyy-MM-dd";

    /**
     * 将字符串转换为日期
     *
     * @param dateStr 时间字符串
     * @return LocalDateTime
     */
    public static LocalDate stringToDate(String dateStr) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(STANDARD_FORMAT);
        return LocalDate.parse(dateStr, dateFormatter);
    }

    /**
     * 将日期转换为字符串
     *
     * @param date LocalDate
     * @return 日期字符串
     */
    public static String dateToString(LocalDate date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(STANDARD_FORMAT);
        return date.format(dateFormatter);
    }

}
