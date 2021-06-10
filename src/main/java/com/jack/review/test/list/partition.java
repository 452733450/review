package com.jack.review.test.list;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/11/16:53
 */
public class partition {
    /*List<List<ProductCreateResult>> partition = Lists.partition(results, PageUtils.DO_BATCH_SIZE);*/
    public static void main(String[] args) {
        List<Integer> numList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> lists=Lists.partition(numList,3);
        System.out.println(lists);  //[[1, 2, 3], [4, 5, 6], [7, 8]]


        /*List<Long> list = Lists.newArrayList();
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(size > 0);
        Lists.partition()*/
    }
}
