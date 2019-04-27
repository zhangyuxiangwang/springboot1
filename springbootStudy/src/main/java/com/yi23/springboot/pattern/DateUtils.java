package com.yi23.springboot.pattern;

import java.util.Calendar;

/**
 * @Author : wangbin
 * @Date : 2019/1/14
 * @Description 日期
 */
public class DateUtils {


    /**
     * 往后推days天  10 向后推10天，-10向前推10天
     * @param date
     * @param days
     * @return
     */
    public static java.util.Date getDateAddOneDay(java.util.Date date, Integer days){

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE,days);
        return instance.getTime();
    }

    /**
     * 往后推times小时
     * @param date
     * @param times
     * @return
     */
    public static java.util.Date getDateAddOneHour(java.util.Date date, Integer times){

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,times);
        return instance.getTime();
    }

    /**
     * 获取月份的第一天 0 为当前月，1是下一个月，-1上一个月 依次类推
     *
     * @param amount
     * @return
     */
    public static java.util.Date getMonthFirstDay(int amount) {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, amount);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        java.util.Date time = c.getTime();
        return time;
    }

    /**
     * 获取月份的最后一天 0 为当前月，1是下一个月，-1上一个月 依次类推
     *
     * @param amount
     * @return
     */
    public static java.util.Date getMonthLastDay(int amount) {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, amount);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        java.util.Date time = c.getTime();
        return time;
    }
}
