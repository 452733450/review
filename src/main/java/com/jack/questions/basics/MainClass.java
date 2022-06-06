package com.jack.questions.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/23/9:39
 */
public class MainClass {
    public static void main(String[] args) {
        String[] arr = new String[]{"jack", "tom"};
        List<Person> personList = new ArrayList<>(arr.length);
        Arrays.stream(arr).forEach(s -> {
            Person person = new Person();
            person.setName(s);
            personList.add(person);
        });

        List<Person> persons = Arrays.stream(arr).map(s -> {
            Person person = new Person();
            person.setName(s);
            return person;
        }).collect(Collectors.toList());
        System.out.println(personList.size());
    }
}
