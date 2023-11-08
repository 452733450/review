package com.jack.test;

import java.io.Serializable;
import java.util.Random;

public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    private final SubwayStation[] stations;
    private Random random = new Random();

    public Bus(SubwayStation[] stations) {
        this.stations = stations;
    }

    public void move() {
        SubwayStation source = stations[random.nextInt(stations.length)];
        SubwayStation target;
        do {
            target = stations[random.nextInt(stations.length)];
        } while (source == target);

        int bikesToMove = random.nextInt(21); // 0-20 bikes
        source.removeBikes(bikesToMove);
        target.addBikes(bikesToMove);
    }
}
