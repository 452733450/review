package com.jack.review.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/17/10:41
 */
public class MainClass {
    public static void main(String[] args) {
        List<Integer> positionStatuses = JsonUtils.json2List("[4]",Integer.class);
        if(!positionStatuses.contains(1) && !positionStatuses.contains(3)) {
            System.out.println("不是客户经理或运营");
        } else {
            System.out.println("send");
        }
    }

}
