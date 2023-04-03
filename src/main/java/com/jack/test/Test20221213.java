package com.jack.test;

import com.google.common.collect.Lists;
import com.jack.review.util.ModelUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2022/12/13/17:09
 */
public class Test20221213 {
    public static void main(String[] args) {
        /*User user1 = User.builder().name("jack").build();
        User user2 = User.builder().name("tom").build();
        User user3 = User.builder().name("tom").build();
        List<User> users = Lists.newArrayList(user1,user2,user3);*/
        User user1 = User.builder().name(null).build();
        List<User> users = Lists.newArrayList();
        List<User> tmp = users.stream().filter(ModelUtils.distinctByKey(User::getName)).collect(Collectors.toList());
        System.out.println(tmp.size());
    }
}
