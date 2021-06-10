package com.jack.review.test.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: stream.peek的操作是返回一个新的stream的，且设计的初衷是用来debug调试的，因此使用steam.peek()必须对流进行一次处理再产生一个新的stream。
 * @Auther: Jack You
 * @Date: 2021/05/11/14:57
 */
public class peek {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 24, "male", "Washington"));

        List<Person> res = personList.stream().filter(e -> e.getAge().equals(24)).peek(person -> person.setAge(1)).collect(Collectors.toList());
        System.out.println(res.size());

    }
}
