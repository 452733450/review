package com.jack.review.test;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/09/15:51
 */
public class nullable {
    // https://www.w3cschool.cn/intellij_idea_doc/intellij_idea_doc-e1mk2emq.html
    public static void main(String[] args) {
        System.out.println(test1(null));
    }

    @NonNull
    // 标在方法上，表示这个方法不能返回空，标在参数上，表示参数不可为空，
    private static String test1(@Nullable String str){
        return str;
    }
}
