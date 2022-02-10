package com.jack.review.test.trycatch;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/20/10:48
 */
public class print {
    public static void main(String[] args) {
        try {
            Integer.parseInt("");
        } catch (NumberFormatException e) {
            System.out.println("Exception1");
        } finally {
            System.out.println("Finally1");
            try {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Exception2");
            } finally {
                System.out.println("Finally2");
            }
        }
    }
}
