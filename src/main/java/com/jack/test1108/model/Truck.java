package com.jack.test1108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:货车类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Truck implements Serializable {

    private static final long serialVersionID = 1L;

    /**
     * 表示货车速度每秒三格子
     */
    private int speed = 3;
    /**
     * 表示货车的每次最大承载量
     */
    private int maxLoadCapacity = 20;
    /**
     * 货车当前的运输量
     */
    private int loadCapacity = 0;

    /**
     * 货车选择的路线
     */
    private Way way;

    /**
     * 起始地铁站
     */
    private SubwayStation originSubwayStation;
    /**
     * 目的地地铁站
     */
    private SubwayStation destSubwayStation;

    /**
     * 货车启动的时间，秒数
     */
    private int startTime;

    /**
     * 起点和终点的距离
     */
    private int distance;


    public Truck(Way way, SubwayStation originSubwayStation, SubwayStation destSubwayStation, int startTime) {
        this.way = way;
        this.originSubwayStation = originSubwayStation;
        this.destSubwayStation = destSubwayStation;
        this.startTime = startTime;
        this.distance = way.getDistance();
    }

    public void setLoadCapacity(int loadCapacity) {
        if (loadCapacity <= maxLoadCapacity)
            this.loadCapacity = loadCapacity;
        else
            System.out.println("当前运送的小黄车数量超过货车最大承载量");
    }



}
