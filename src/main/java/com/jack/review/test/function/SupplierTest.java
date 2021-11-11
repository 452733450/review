package com.jack.review.test.function;

import java.util.function.Supplier;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/29/13:24
 */
public class SupplierTest {
    public static void main(String[] args) {
        //定义一个int数组
        int[] arr = {19, 50, 28, 37, 46};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
    }

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
