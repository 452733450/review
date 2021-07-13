package com.jack.review.test.hashMap;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.relational.core.sql.In;

import java.util.HashMap;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/29/9:11
 */
public class mapUtils {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        HashMap<String,String> map = Maps.newHashMap();
        map.put("1","2");
        map.put("2","2");
        Long l = MapUtils.getLong(map,"1");
        System.out.println(l);
    }
}
