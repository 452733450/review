package com.jack.asset;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/22/14:30
 */
public class Test20220622 {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("00.3456");
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        System.out.println(percent.format(b.doubleValue()));
        System.out.println(b.toPlainString());
        System.out.println(b.toString());
        System.out.println(b.toEngineeringString());

        System.out.println(getRemainSecondsOneDay(new Date()));
    }

    // 获取当前时间距离一天结束的剩余秒数
    public static Integer getRemainSecondsOneDay(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);

        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());

        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }
}
