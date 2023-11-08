package com.jack.test.demo;

public class SubwayMap {
    private SubwayStation[][] map;
    private int x;
    private int y;

    public SubwayMap(int x, int y) {
        this.x = x;
        this.y = y;
        map = new SubwayStation[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = new SubwayStation("Station" + (i * y + j), 0);
            }
        }
    }

    public SubwayStation getStation(int x, int y) {
        return map[x][y];
    }

    public void setStation(int x, int y, SubwayStation station) {
        map[x][y] = station;
    }
}
