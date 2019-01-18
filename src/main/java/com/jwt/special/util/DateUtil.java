package com.jwt.special.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2019/1/17 0017 下午 3:45
 */
public class DateUtil {
    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds   精确到秒的时间戳
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 时间戳转换成指定的日期格式
     * @param seconds   精确到秒的时间戳
     * @param format
     * @return
     */
    public static Date timeStampToDate(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return null;
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String d = sdf.format(Long.valueOf(seconds));
        Date parse = null;
        try {
            parse = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str   字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    public static Date parseDate(String time,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(time);
    }

    /**
     * 将日期格式转换成String
     *
     * @author chenssy
     * @data Dec 31, 2013
     * @param value
     *            需要转换的日期
     * @param format
     *            日期格式
     * @return String
     */
    public static String date2String(Date value, String format) {
        if (value == null) {
            return null;
        }

        SimpleDateFormat sdf = getFormat(format);
        return sdf.format(value);
    }

    /**
     * 获取日期显示格式，为空默认为yyyy-mm-dd HH:mm:ss
     *
     * @author chenssy
     * @data Dec 30, 2013
     * @param format
     * @return
     * @return SimpleDateFormat
     */
    private static SimpleDateFormat getFormat(String format) {
        if (format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(format);
    }

    /***
     * 获取传入日期的当天最小时间
     * @param date
     * @return
     */
    public static Date getCurrentDayMintime(Date date){
        if (date == null) {return null;}
        try {
            String dateStr = date2String(date, "yyyy-MM-dd");
            dateStr += " 00:00:00";
            date = string2Date(dateStr, "yyyy-MM-dd HH:mm:ss");
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /***
     * 获取传入日期的当天最大时间
     * @param date
     * @return
     */
    public static Date getCurrentDayMaxtime(Date date){
        if (date == null) {return null;}
        try {
            String dateStr = date2String(date, "yyyy-MM-dd");
            dateStr += " 23:59:59";
            date = string2Date(dateStr, "yyyy-MM-dd HH:mm:ss");
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串(格式符合规范)转换成Date
     *
     * @author chenssy
     * @data Dec 31, 2013
     * @param value
     *            需要转换的字符串
     * @param format
     *            日期格式
     * @return Date
     * @throws Exception
     */
    public static Date string2Date(String value, String format)
            throws Exception {
        if (value == null || "".equals(value)) {
            return null;
        }

        SimpleDateFormat sdf = getFormat(format);
        Date date = null;
        //value = formatDate(value, format);
        try {
            date = sdf.parse(value);
        } catch (ParseException e) {
            throw new Exception("时间转换出错..");
        }
        return date;
    }

    public static void main(String args[])throws Exception{
        Date now = new Date();
        String signDateStr = DateUtil.date2String(now, "yyyy-MM-dd HH:mm:ss");
        String hourMinSec = signDateStr.substring(11, signDateStr.length());

        String newSignDateStr = "2015-08-23" + " " + hourMinSec;
        Date newSignDate = DateUtil.string2Date(newSignDateStr, "yyyy-MM-dd HH:mm:ss");
        System.out.println(newSignDate);
        System.out.println(DateUtil.date2String(newSignDate,"yyyy-MM-dd HH:mm:ss"));
    }
}
