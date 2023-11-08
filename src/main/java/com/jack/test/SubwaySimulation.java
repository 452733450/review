package com.jack.test;

import java.util.Random;

public class SubwaySimulation {

    public static void main(String[] args) {
        SubwayStation aStation = new SubwayStation("A", 30);
        SubwayStation bStation = new SubwayStation("B", 40);
        SubwayStation cStation = new SubwayStation("C", 30);
        SubwayStation[] stations = {aStation, bStation, cStation};

        Bus bus1 = new Bus(stations);
        Bus bus2 = new Bus(stations);

        for (int second = 1; second <= 200; second++) {
            for (Bus bus : new Bus[]{bus1, bus2}) {
                bus.move();
            }

            for (SubwayStation station : stations) {
                int bikesNeeded = new Random().nextInt(11); // 0-10 bikes needed
                if (station.getBikes() < bikesNeeded) {
                    station.addBikes(bikesNeeded - station.getBikes());
                }
                station.removeBikes(bikesNeeded);
            }

            System.out.println("Second " + second + ":");
            for (SubwayStation station : stations) {
                System.out.println(station.getName() + " Station - Bikes: " + station.getBikes());
            }
        }
    }
}
