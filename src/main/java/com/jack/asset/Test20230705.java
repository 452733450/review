package com.jack.asset;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test20230705 {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);

        List<Integer> list2 = Lists.newArrayList(2, 2, 3);

        list1.retainAll(list2);
        System.out.println(list1);
    }
}
