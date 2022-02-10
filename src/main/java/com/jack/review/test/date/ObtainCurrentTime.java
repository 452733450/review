package com.jack.review.test.date;

import cn.hutool.core.lang.Assert;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/21/15:53
 */
public class ObtainCurrentTime {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDate.now());
        if(LocalDate.now().compareTo(LocalDate.now().plusDays(1))<0){
            System.out.println("当前时间大于");
        }

        isAfterNow(localDate2Date(LocalDate.now()));

    }

    public static void isAfterNow(Date date){
        System.out.println(date2LocalDate(date));
        System.out.println(LocalDate.now());
        Assert.isTrue(LocalDate.now().compareTo(date2LocalDate(date)) >= NumberUtils.LONG_ZERO, "净值日期不可大于当前日期");
    }

    public static Date localDate2Date(LocalDate localDate) {

        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static LocalDate date2LocalDate(Date date) {

        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public static void test(){
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1.compareTo(date2) >= 0);
    }
}
