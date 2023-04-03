package com.jack.test;

import com.jack.review.util.DateUtils;

import java.util.Date;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2023/02/21/11:16
 */
public class Test20230221 {
    public static void main(String[] args) {
        Date now = DateUtils.parse(DateUtils.getNow(DateUtils.FORMAT_SHORT), DateUtils.FORMAT_SHORT);
        Date date = DateUtils.parse("2023-02-22", DateUtils.FORMAT_SHORT);

        assert date != null;
        assert now != null;
        int a = date.compareTo(now);
        System.out.println(a);
    }
}
