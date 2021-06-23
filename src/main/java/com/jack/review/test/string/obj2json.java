package com.jack.review.test.string;

import com.jack.review.util.JsonUtils;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/16/11:11
 */
public class obj2json {
    public static void main(String[] args) {
        int[] dealerIds = new int[]{1, 2};
        System.out.println(JsonUtils.obj2Json(dealerIds));
    }
}
