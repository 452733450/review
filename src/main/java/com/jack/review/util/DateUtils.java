package com.jack.review.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        strToDate();
    }
}
