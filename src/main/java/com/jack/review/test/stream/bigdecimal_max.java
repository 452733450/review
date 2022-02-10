package com.jack.review.test.stream;

import com.google.common.collect.Lists;
import com.jack.review.web.entity.User;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/22/16:31
 */
public class bigdecimal_max {
    public static void main(String[] args) {
        User user1 = User.builder()
                .age(1)
                .name("jack")
                .money(BigDecimal.ZERO)
                .build();

        User user2 = User.builder()
                .age(2)
                .name("tom")
                .money(BigDecimal.ONE)
                .build();
        User user3 = User.builder()
                .age(2)
                .name("tom")
                .money(new BigDecimal("1.234"))
                .build();
        List<User> users = Lists.newArrayList(user1,user2,user3);
        User user = users.stream().max(Comparator.comparing(User::getMoney)).orElse(null);
        assert user != null;
        System.out.println(user.getMoney());
    }
}
