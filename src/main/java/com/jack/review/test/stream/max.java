package com.jack.review.test.stream;

import java.util.*;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/11/11:19
 */
public class max {
    public static void main(String[] args) {


    }

    // 获取String集合中最长的元素。
    public static void getMaxLength(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }

    // 获取Integer集合中的最大值
    public static void getMaxInteger() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }

    // 获取员工工资最高的人
    public static void getMaxSalary() {
        List<Person> personList = new ArrayList<>();

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max.get().getSalary());
    }

    // 计算Integer集合中大于6的元素的个数
    public static void count(){
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);

        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }



}
