package com.jack.review.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description: 归约
 * @Auther: Jack You
 * @Date: 2021/05/11/14:34
 */
public class reducing {

    //Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持

    public static void main(String[] args) {

    }

    public static void test(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        /*Integer sum = personList.stream().map(Person::getSalary).reduce(0, (i, j) -> (i + j - 5000));*/
        System.out.println("员工扣税薪资总和：" + sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }
}
