package com.jack.test;

import org.apache.commons.lang3.StringUtils;

public class Test20230711 {
    public static void main(String[] args) {
        String param = "50";
        Long limit = null;
        if (StringUtils.isNotBlank(param)) {
            limit = Long.parseLong(param);
        }
        System.out.println(limit);

        String gcName = System.getProperty("java.vm.gc");
        System.out.println("Default Garbage Collector: " + gcName);

    }
}
