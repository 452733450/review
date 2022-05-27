package com.jack.review.test.string;

public class MainClass {
    public static void main(String[] args) {
        String a = "abc";
        String b = "a" + "b" + "c";
        String c = new String("abc");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(c));
    }
}
