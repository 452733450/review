package com.jack.test1108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 表示位置的类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location implements Serializable {
    private static final long serialVersionID = 1L;

    private static final Map<String, Integer> xMap = new HashMap<>();
    static {
        xMap.put("a", 1);
        xMap.put("b", 2);
        xMap.put("c", 3);
        xMap.put("d", 4);
        xMap.put("e", 5);
        xMap.put("f", 6);
        xMap.put("g", 7);
        xMap.put("h", 8);
    }

    /**
     * x轴，由于是a,b,c,d...表示的，计算不方便，所以将其映射成int类型，当然实际生活中肯定是用经纬度来计算的
     */
    private int xAxis;

    /**
     * y轴
     */
    private int yAxis;

    public Location(String xAxis, int yAxis) {
        this.xAxis = xMap.get(xAxis);
        this.yAxis = yAxis;
    }


}
