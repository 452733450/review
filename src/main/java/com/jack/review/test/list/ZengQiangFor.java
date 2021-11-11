package com.jack.review.test.list;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/23/14:21
 */
public class ZengQiangFor {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(2,3,4);
        for(Integer i :list ) {
            if(i.equals(1)) {
                continue;
            }
            System.out.println(i);
        }
    }
}
