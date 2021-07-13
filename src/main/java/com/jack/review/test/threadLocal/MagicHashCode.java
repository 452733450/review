package com.jack.review.test.threadLocal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/24/15:54
 */
public class MagicHashCode {
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        hashCode(16); //初始化16
        hashCode(32); //后续2倍扩容
        hashCode(64);
    }

    private static void hashCode(Integer length) {
        int hashCode = 0;
        for (int i = 0; i < length; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;//每次递增HASH_INCREMENT
            System.out.print(hashCode & (length - 1));
            System.out.print(" ");
        }
        System.out.println();
    }
}
