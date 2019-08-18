package com.chxf.user.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 格式化日期
 */
public class DateUtil {
    /** ===========================yyyy开头================================ */
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public final static SimpleDateFormat YYYY_MM_DD_HH_MM_SS_ = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    /**
     * yyyy-MM-dd HH:mm
     */
    public final static SimpleDateFormat YYYY_MM_DD_HH_MM = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
    /**
     * yyyy-MM-dd HH:mm
     */
    public final static SimpleDateFormat HH_MM = new SimpleDateFormat(
            "HH:mm");

    /**
     * yyyy-MM-dd
     */
    public final static SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat(
            "yyyy-MM-dd");
    /**
     * yyyy-MM-dd
     */
    public final static SimpleDateFormat YYYY_MM = new SimpleDateFormat(
            "yyyy-MM");
    /**
     * yyyy-MM-dd
     */
    public final static SimpleDateFormat YYYY = new SimpleDateFormat(
            "yyyy");
    /**
     * yyyy-MM-dd
     */
    public final static SimpleDateFormat MM_DD = new SimpleDateFormat(
            "MM-dd");
    /**
     * yyyyMMddHHmmss
     */
    public final static SimpleDateFormat yyyyMMddHHmmss_format = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    /**
     * yyyyMMdd
     */
    public final static SimpleDateFormat yyyyMMdd_format = new SimpleDateFormat(
            "yyyyMMdd");
    /** ===========================yyyy年开头================================ */
    /**
     * yyyy年MM月dd日 HH:mm:ss
     */
    public final static SimpleDateFormat yyyyYearMMMonthddDayHHmmss_format = new SimpleDateFormat(
            "yyyy年MM月dd日 HH:mm:ss");
    /**
     * yyyy年MM月dd日
     */
    public final static SimpleDateFormat yyyyYearMMMonthddDay_format = new SimpleDateFormat(
            "yyyy年MM月dd日");
    /** ===========================yy开头================================ */
    /**
     * yyMMddHHmmss
     */
    public final static SimpleDateFormat yyMMddHHmmss_format = new SimpleDateFormat(
            "yyMMddHHmmss");
    /**
     * yyMMdd
     */
    public final static SimpleDateFormat yyMMdd_format = new SimpleDateFormat(
            "yyMMdd");
    /** ===========================英文================================ */
    /**
     * MMM：英文月份前三个字母
     */
    public final static SimpleDateFormat MMM_format = new SimpleDateFormat(
            "MMM", Locale.ENGLISH);


    /**
     * 将日期格式化为字符串
     */
    public static String toString(Date date, SimpleDateFormat format) {
        String str = null;
        if (date != null && format != null) {
            str = format.format(date);
        }
        return str;
    }

    /**
     * 字符串转日期
     */
    public static Date toDate(String str, SimpleDateFormat formatt) {
        Date date = null;
        if (formatt != null && StringUtil.isNotEmpty(str)) {
            try {
                date = formatt.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 判断两个其实是否为同一天
     */
    public static boolean isSameDay(Date date, Date date2) {
        boolean bl = false;
        if (date != null && date2 != null) {
            bl = getNumByUnit(date, date2, YYYY_MM_DD, 1000 * 3600 * 24) == 0 ? true
                    : false;
        }
        return bl;
    }

    /**
     * @param date          参照时间
     * @param afterNum      时间单位的数量
     * @param calendar_unit 时间单位:Calendar.YEAR年 或Calendar.MONTH月 或Calendar.DAY_OF_MONTH日
     *                      或Calendar.HOUR_OF_DAY小时
     * @功能：计算当前时间的若干单位后的时间
     * @参数：
     * @返回参数：Date 若为null表示参数不合法
     */
    public static Date afterDate(Date date, int afterNum, int calendar_unit) {
        Date date2 = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(calendar_unit, afterNum);
            date2 = cal.getTime();
        }
        return date2;
    }

    /**
     * @param before 在前的时间
     * @param after  在后的时间
     * @param format 精确度
     * @param unit   单位毫秒时间
     * @功能：根据单位毫秒时间和精确度计算时间差值
     * @参数：
     * @返回参数：Long 若为null表示参数不合法
     */
    public static Long getNumByUnit(String before, String after,
                                    SimpleDateFormat format, int unit) {
        Long i = null;
        if (StringUtil.isNotEmpty(before) && StringUtil.isNotEmpty(after)
                && format != null && unit > 0) {
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(format.parse(before));
                long time1 = cal.getTimeInMillis();
                cal.setTime(format.parse(after));
                long time2 = cal.getTimeInMillis();
                i = (time2 - time1) / unit;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /**
     * @param before 在前的时间
     * @param after  在后的时间
     * @param format 精确度
     * @param unit   单位毫秒时间
     * @功能：根据单位毫秒时间和精确度计算时间差值
     * @参数：
     * @返回参数：Long 若为null表示参数不合法
     */
    public static Long getNumByUnit(Date before, Date after,
                                    SimpleDateFormat format, int unit) {
        Long i = null;
        if (before != null && after != null && format != null && unit > 0) {
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(format.parse(toString(before, format)));
                long time1 = cal.getTimeInMillis();
                cal.setTime(format.parse(toString(after, format)));
                long time2 = cal.getTimeInMillis();
                i = (time2 - time1) / unit;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /**
     * @param before 在前的时间
     * @param after  在后的时间
     * @功能：比较时间先后
     * @参数：
     * @返回参数：Integer 若为null表示参数不合法;before在前返回1;相等返回0;before在后返回-1
     */
    public static Integer compareTo(Date before, Date after) {
        Integer i = null;
        if (before != null && after != null) {
            i = after.compareTo(before);
        }
        return i;
    }

    public static void main(String[] args) {
        // Date before = toDate("2017-06-07 08:11:56", yyyy_MM_ddHHmmss_format);
        //Date after = toDate("2018-06-07 07:07:50", YYYY_MM_DD_HH_MM);
        String date = toString(new Date(), HH_MM);
        System.out.println(date);
    }
}