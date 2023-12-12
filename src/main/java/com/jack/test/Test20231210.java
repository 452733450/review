package com.jack.test;

public class Test20231210 {
    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test2());
    }

    public static Integer test() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static int test2() {
        int i = 1;
        try {
            return i + 1;
        } catch (Exception e) {
            return 3;
        } finally {
            i = 100;
        }
    }
}
