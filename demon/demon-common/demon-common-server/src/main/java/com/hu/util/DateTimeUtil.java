package com.hu.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.TemporalAdjusters.*;


public class DateTimeUtil {

    public static int MILLISECOND = 1000;
    public static int SECOND = 60;
    public static int MINUTE = 60;
    public static int HOUR = 24;

    public static long TIMESTAMP = 1000000000000L;
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * LocalDateTime转时间字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String getDateStringByLocalDateTime(LocalDateTime localDateTime, String format) throws Exception {
        if (StringUtils.isBlank(format)) {
            throw new Exception("时间格式不能为空");
        }
        if (localDateTime == null) {
            throw new Exception("时间不能为空");
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return df.format(localDateTime);
    }

    /**
     * 时间字符串转LocalDateTime
     *
     * @param dateString
     * @param format
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeByDateString(String dateString, String format) throws Exception {
        if (StringUtils.isBlank(format)) {
            throw new Exception("时间格式不能为空");
        }
        if (StringUtils.isBlank(dateString)) {
            throw new Exception("时间不能为空");
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateString, df);
    }

    /**
     * LocalDateTime转Timestamp
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfLocalDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * Timestamp转LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getLocalDateOfTimeTimestamp(Long timestamp) throws Exception {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date转时间字符串
     *
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static String getDateStringByDate(Date date, String format) throws Exception {
        if (StringUtils.isBlank(format)) {
            throw new Exception("时间格式不能为空");
        }
        if (date == null) {
            throw new Exception("时间不能为空");
        }
        SimpleDateFormat simple = new SimpleDateFormat(format);
        return simple.format(date);
    }

    /**
     * 时间字符串转Date
     *
     * @param dateString
     * @param format
     * @return
     * @throws Exception
     */
    public static Date getDateByFormat(String dateString, String format) throws Exception {
        if (StringUtils.isBlank(format)) {
            throw new Exception("时间格式不能为空");
        }
        if (StringUtils.isBlank(dateString)) {
            throw new Exception("时间不能为空");
        }
        SimpleDateFormat simple = new SimpleDateFormat(format);
        return simple.parse(dateString);
    }

    /**
     * 时间戳转时间字符串
     *
     * @param timestamp
     * @param format
     * @return
     * @throws Exception
     */
    public static String getDateStringByTimestamp(Long timestamp, String format) throws Exception {
        return getDateStringByLocalDateTime(getLocalDateOfTimeTimestamp(timestamp), format);
    }

    /**
     * 时间戳转时间字符串
     *
     * @param dateString
     * @param format
     * @return
     * @throws Exception
     */
    public static long getTimestampByDateString(String dateString, String format) throws Exception {
        return getTimestampOfLocalDateTime(getLocalDateTimeByDateString(dateString, format));
    }

    /**
     * 时间字符串比当前时间早几分钟
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static int getMinuteToNow(String time) throws Exception {
        long timestamp = getTimestampOfLocalDateTime(getLocalDateTimeByDateString(time, YYYY_MM_DD_HH_MM_SS));
        long systemTimestamp = System.currentTimeMillis();
        if (getLocalDateTimeByDateString(time, YYYY_MM_DD_HH_MM_SS).isAfter(LocalDateTime.now())) {
            throw new Exception("时间超前异常");
        }
        return (int) ((systemTimestamp - timestamp) / (SECOND * MILLISECOND));
    }

    /**
     * 获取本天的最初时间
     *
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeOfDayFirstTime() throws Exception {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * 获取本天的最后时间
     *
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeOfDayLastTime() throws Exception {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }


    /**
     * 获取本月的最初时间
     *
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeOfMonthFirstTime() throws Exception {
        return LocalDateTime.of(LocalDate.now().with(firstDayOfMonth()), LocalTime.MIN);
    }

    /**
     * 获取下个月的最初时间
     *
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeOfNextMonthFirstTime() throws Exception {
        return LocalDateTime.of(LocalDate.now().with(firstDayOfNextMonth()), LocalTime.MIN);
    }

    /**
     * 获取本月的最后时间
     *
     * @return
     * @throws Exception
     */
    public static LocalDateTime getLocalDateTimeOfMonthLastTime() throws Exception {
        return LocalDateTime.of(LocalDate.now().with(lastDayOfMonth()), LocalTime.MAX);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getLocalDateTimeOfDayLastTime());
    }


}

