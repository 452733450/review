package com.jack.test.demo;

import lombok.Data;

@Data
public class SubwayStation {
    private String name;
    private int bikes;

    public SubwayStation(String name, int initialBikes) {
        this.name = name;
        this.bikes = initialBikes;
    }

    public int addBike() {
        return bikes++;
    }

    public int removeBike() {
        if (bikes > 0) {
            bikes--;
            return bikes;
        }
        return bikes;
    }

    public int getBikeCount() {
        return bikes;
    }

    public String getName() {
        return name;
    }
}
