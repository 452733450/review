package com.jack.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Test20230531 {
    public static void main(String[] args) {
        String dateTimeString = "2023-05-31T02:55:24.473Z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

// 解析时间字符串并转换为 Instant 对象
        Instant instant = Instant.parse(dateTimeString);

// 转换为本地时间
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

// 格式化为指定格式
        String formattedDateTime = localDateTime.format(formatter);

        System.out.println(formattedDateTime);
    }
}
