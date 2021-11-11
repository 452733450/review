package com.jack.review.test.hashMap;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","2");
        concurrentHashMap.get("1");
        map.put("1","2");
        map.put("2","2");
        map.get("1");
        HashMap<String,String> map1 = new HashMap<>(16);
        Long l = MapUtils.getLong(map,"1");
        System.out.println(l);
    }
}
