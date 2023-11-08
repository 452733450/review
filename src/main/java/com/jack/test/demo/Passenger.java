package com.jack.test.demo;

import lombok.Data;

@Data
public class Passenger {

    private Integer speed;

    public int rideBike(SubwayStation station) {
        return station.removeBike();
    }
}
