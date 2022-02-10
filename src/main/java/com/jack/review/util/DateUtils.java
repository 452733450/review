package com.jack.review.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/07/15:43
 */
public class DateUtils {

    private static Date strToDate() {
        String timeStr = "2018&&11##13//16%%02**02";
        SimpleDateFormat format = new SimpleDateFormat("yyyy&&MM##dd//HH%%mm**ss");
        try {
            System.out.println(format.parse(timeStr));
            return format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //这个是要转换的字符串
        String dat="Thu Jul 01 00:00:00 GMT+08:00 2021";
        System.out.println(parseTimeZone(dat));
    }

    public static String parseTimeZone(String dateString) {
        String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
        String FORMAT_STRING2 = "EEE MMM dd HH:mm:ss z yyyy";
        String[] REPLACE_STRING = new String[]{"GMT+0800", "GMT+08:00"};
        String SPLIT_STRING = "(中国标准时间)";
        try {
            dateString = dateString.split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]);
            //转换为date
            SimpleDateFormat sf1 = new SimpleDateFormat(FORMAT_STRING2, Locale.ENGLISH);
            Date date = sf1.parse(dateString);
            return new SimpleDateFormat(FORMAT_STRING).format(date);
        } catch (Exception e) {
            throw new RuntimeException("时间转化格式错误" + "[dateString=" + dateString + "]" + "[FORMAT_STRING=" + FORMAT_STRING + "]");
        }
    }

}
