package com.jack.review.test.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/20/10:16
 */
public class Outer {
    public Inner someOuterMethod(){
        return new Inner();
    }
    public class Inner{

    }

    public static void main(String[] args) {
        /*Outer o = new Outer();
        Inner inner = o.new Inner();
        Inner inner1 = new o.Inner();
        Inner inner2 = new Outer().Inner();*/
        /*ArrayList;
        LinkedList;
        HashMap;*/
        int i1 = 0 ;
        int i2 = 0 ;
        Integer i3 = 120;
        Integer i4 = 120;
        Integer i5 = 0;
        Integer i6 = new Integer(120);
        Integer i7 = new Integer(120);
        Double d1 = 120.0;
        Double d2 = 120.0;
        Double d3 = new Double(120.0);
        Double d4 = new Double(120.0);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i3 == i4 + i5);

        System.out.println(i6 == i7);

        System.out.println(i6 == i5+i7);

        System.out.println(d1 == d2);
        System.out.println(d3 == d4);
        System.out.println(d1 == d3);

        Integer a = 100;
        Integer b = 100;
        Integer c = 100;
        Integer d = 100;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
