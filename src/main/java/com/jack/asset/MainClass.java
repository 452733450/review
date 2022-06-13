package com.jack.asset;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/05/29/18:32
 */
public class MainClass {
    public static void main(String[] args) {
        /*String birth = "1991".substring(0, 4);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - Integer.parseInt(birth);
        System.out.println(age);*/

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        calendar.set(2022, 12, 9);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(day);


        /*LocalDate now = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(3);
        List<LocalDate> localDates = Stream.iterate(now.plusDays(1), date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(now, end.minusDays(1)))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(localDates.size());*/
        /*int sendDay = 7;
        int weekday;
        if (day == 1) {
            weekday = 7;
        } else {
            weekday = day - 1;
        }
        int adder;
        if (weekday <= sendDay) {
            adder = sendDay - weekday;
        } else {
            adder = 7 - weekday + sendDay;
        }
        System.out.println(adder);

        LocalDate localDate = new MainClass().getSendDay(calendar, 3);
        System.out.println(localDate);*/
    }


    public LocalDate getSendDay(Calendar calendar, int sendDay) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekday;
        if (dayOfWeek == 1) {
            weekday = 7;
        } else {
            weekday = dayOfWeek - 1;
        }
        int count;
        if (weekday <= sendDay) {
            count = sendDay - weekday;
        } else {
            count = 7 - weekday + sendDay;
        }
        return LocalDate.now().plusDays(count);
    }

}
