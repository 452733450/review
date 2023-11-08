package com.jack.test1108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 表示路线的类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Way implements Serializable {

    private static final long serialVersionID = 1L;

    /**
     * 路线的总里程
     */
    private int distance;

    /**
     * 起始地铁站
     */
    private SubwayStation originSubwayStation;

    /**
     * 目的地地铁站
     */
    private SubwayStation destSubwayStation;

    public Way(SubwayStation originSubwayStation, SubwayStation destSubwayStation, int distance) {
        this.originSubwayStation = originSubwayStation;
        this.destSubwayStation = destSubwayStation;
        this.distance = distance;
    }
}
