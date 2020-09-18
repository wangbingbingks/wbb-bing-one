package com.corsface.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Riky on 2015/10/14.
 * Desc:
 */
public class DateUtils {
    private static final String TAG = "DateUtils";

    public static final String ENG_DATE_FROMAT = "EEE, d MMM yyyy HH:mm:ss z";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_U = "yyyy/MM/dd";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";


    /**
     *
     * @Title: date2date
     * @Description: 格式化日期对象
     * @param @param date
     * @param @param formatStr
     * @param @return 设定文件
     * @return Date 返回类型
     * @throws
     */
    public static Date date2date(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String str = sdf.format(date);
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }


    /**
     *
     * @Title: date2string
     * @Description: 时间对象转换成字符串
     * @param @param date
     * @param @param formatStr
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String date2string(Date date, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(date);
        return strDate;
    }

    public static String date2FullString(Date date) {
        String strDate = "";
        if (date==null)
        {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        strDate = sdf.format(date);
        return strDate;
    }



    /**
     *
     * @Title: timestamp2string
     * @Description: sql时间对象转换成字符串
     * @param @param timestamp
     * @param @param formatStr
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String timestamp2string(Timestamp timestamp, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(timestamp);
        return strDate;
    }


    /**
     *
     * @Title: string2date
     * @Description: 字符串转换成时间对象
     * @param @param dateString
     * @param @param formatStr
     * @param @return 设定文件
     * @return Date 返回类型
     * @throws
     */

    public static Date string2date(String dateString, String formatStr) {
        Date formateDate = null;
        DateFormat format = new SimpleDateFormat(formatStr);
        try {
            formateDate = format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return formateDate;
    }

    /**
     *
     * @Title: date2timestamp
     * @Description: Date类型转换为Timestamp类型
     * @param @param date
     * @param @return 设定文件
     * @return Timestamp 返回类型
     * @throws
     */
    public static Timestamp date2timestamp(Date date) {
        if (date == null)
            return null;
        return new Timestamp(date.getTime());
    }

    /**
     *
     * @Title: getNow
     * @Description: 指定时间距离当前时间的中文信息
     * @param @param time
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String getNow(long time) {
        Calendar cal = Calendar.getInstance();
        long timel = cal.getTimeInMillis() - time;
        if (timel / 1000 < 60) {
            return "1分钟以内";
        } else if (timel / 1000 / 60 < 60) {
            return timel / 1000 / 60 + "分钟前";
        } else if (timel / 1000 / 60 / 60 < 24) {
            return timel / 1000 / 60 / 60 + "小时前";
        } else {
            return timel / 1000 / 60 / 60 / 24 + "天前";
        }
    }


    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    public static Date addTime(Date time, int year, int month, int day, int hour, int min,int sec)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        calendar.add(Calendar.YEAR,year);
        calendar.add(Calendar.MONTH,month);
        calendar.add(Calendar.DAY_OF_MONTH,day);

        calendar.add(Calendar.HOUR_OF_DAY,hour);
        calendar.add(Calendar.MINUTE,min);
        calendar.add(Calendar.SECOND,sec);

        return calendar.getTime();

    }


}
