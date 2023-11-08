package com.jack.test.demo;

import java.util.Random;

public class SubwaySimulation {
    public static void main(String[] args) {
        int x = 8; // 格子的行数
        int y = 8; // 格子的列数
        int truckSpeed = 3; // 货车速度，每秒移动格子数
        int bikeSpeed = 1; // 小黄车速度，每秒移动格子数

        SubwayMap map = new SubwayMap(x, y);

        SubwayStation stationA = new SubwayStation("A", 30);
        SubwayStation stationB = new SubwayStation("B", 40);
        SubwayStation stationC = new SubwayStation("C", 30);

        map.setStation(0, 0, stationA); // 设置A站的位置
        map.setStation(7, 7, stationB); // 设置B站的位置
        map.setStation(3, 2, stationC); // 设置C站的位置

        int simulationTime = 200;
        Random random = new Random();

        for (int t = 0; t < simulationTime; t++) {
            // 模拟乘客骑行
            int randomX = random.nextInt(x);
            int randomY = random.nextInt(y);
            SubwayStation randomStation = map.getStation(randomX, randomY);
            randomStation.removeBike();

            // 模拟货车移动
            if (t % truckSpeed == 0) {
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        SubwayStation station = map.getStation(i, j);
                        int bikesLoaded = stationA.removeBike();
                        int bikesUnloaded = randomStation.addBike();
                        System.out.printf("%02d:00:00 %s 到 %s 运输 %d 辆车，", t, stationA.getName(), randomStation.getName(), bikesUnloaded);
                    }
                }
            }

            // 输出地铁站状态
            System.out.printf("地铁站状态: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    SubwayStation station = map.getStation(i, j);
                    System.out.printf("%s站车 %d, ", station.getName(), station.getBikeCount());
                }
            }
            System.out.print("路上车 " + (x * y - stationA.getBikeCount() - stationB.getBikeCount() - stationC.getBikeCount()));
            System.out.println();
        }
    }
}



