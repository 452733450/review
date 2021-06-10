package com.jack.review.test.Object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/04/16:04
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
//        https://zhuanlan.zhihu.com/p/80926041 读取json
        ObjectMapper objectMapper = new ObjectMapper();
        A a= new A();
        a.setStr("str");
        System.out.println(objectMapper.writeValueAsString(a));

        // 反序列化
        String s = "{\"package\":\"v\"}";
        System.out.println(objectMapper.readValue(s,A.class).getStr());

        String jsonStr = "{\"real_name\":\"zhangsan\"}";
        Student student = new ObjectMapper().readValue(jsonStr.getBytes(), Student.class);
        System.out.println(student);
    }

    @Data
    static class A {
        // 作用是把该属性的名称序列化为另外一个名称
        @JsonProperty("package")
        private String str;
    }

    static class Student {
        @JsonProperty("real_name")
        private String realName;

        @Override
        public String toString() {
            return "Student{" +
                    "realName='" + realName + '\'' +
                    '}';
        }
    }
}
