package com.jack.test;

import com.alibaba.fastjson.JSONObject;

public class Test20230823 {
    public static void main(String[] args) {
        String param = "{\"limit\":\"200\",\"companyCode\":\"2251\"}";
        JSONObject jsonParam = JSONObject.parseObject(param);
        System.out.println(jsonParam.toJSONString());
        Long limit = jsonParam.getLongValue("limit");
        Long companyCode = jsonParam.getLongValue("companyCode");
        System.out.println(limit+","+companyCode);
    }
}
