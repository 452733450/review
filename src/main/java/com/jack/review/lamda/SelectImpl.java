package com.jack.review.lamda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/12/14:43
 */
public class SelectImpl implements Select{
    @Override
    public List<Integer> findById(Integer id) {
        System.out.println("实现查询");
        return Lists.newArrayList(1);
    }
}
