package com.jack.review.test.dmResult;

import com.google.common.collect.Lists;
import com.jack.review.util.DmResult;
import com.jack.review.web.entity.User;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/30/9:48
 */
public class MainClass {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        List<User> users = Lists.newArrayList(new User(1, "jack", null), new User(2, "amy", null));
        List<User> users1 = Lists.newArrayList(new User(null, "jack", null), new User(null, "amy", null));
        DmResult<User> dmResult = DmResult.build(users, users1, User::getAge);
        System.out.println(dmResult.getNeedDeleteResults());
    }
}
