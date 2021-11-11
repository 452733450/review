package com.jack.review.test.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/11/05/13:39
 */
public class subList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                List<Integer> list2 = list.subList(0, i + 1);
                System.out.println(list2.size());
            }
        }
    }
}
