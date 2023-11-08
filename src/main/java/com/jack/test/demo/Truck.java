package com.jack.test.demo;

public class Truck {
    private String name;
    private int maxCapacity;
    private int currentCapacity;

    public Truck(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    public int loadBikes(SubwayStation station) {
        int bikesToLoad = Math.min(maxCapacity - currentCapacity, station.getBikeCount());
        station.removeBike();
        currentCapacity += bikesToLoad;
        return bikesToLoad;
    }

    public int unloadBikes(SubwayStation station) {
        int bikesToUnload = Math.min(currentCapacity, maxCapacity - station.getBikeCount());
        station.addBike();
        currentCapacity -= bikesToUnload;
        return bikesToUnload;
    }
}
