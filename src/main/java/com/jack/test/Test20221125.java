package com.jack.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/25/10:43
 */
public class Test20221125 {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(1);
        list1.retainAll(list2);
        int size = list1.size();
        System.out.println(size);
    }
}
