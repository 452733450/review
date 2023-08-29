package com.jack.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test20230818 {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Jack", "Tom", "Jerry");
        String str = String.join(",", names);
        System.out.println(str);
    }
}
