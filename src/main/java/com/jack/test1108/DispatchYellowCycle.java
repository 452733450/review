package com.jack.test1108;

import com.jack.test1108.model.Passenger;
import com.jack.test1108.model.SubwayStation;
import com.jack.test1108.model.Truck;
import com.jack.test1108.model.Way;
import com.jack.test1108.util.YellowCycleUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 小黄车调度中心
 */
public class DispatchYellowCycle {
    public static void main(String[] args) throws InterruptedException {
        // 由于此处主要是乘客集合，而且查找相对比较少，删除比较多，所以使用链表
        List<Passenger> passengerList = new LinkedList<>();
        // 初始化两辆货车
        List<Truck> truckList = new ArrayList<>(2);

        for (int second = 0; second <= 200; second++) {
            if (second == 0) {
                System.out.println("第0秒,A站车:" + YellowCycleUtil.aSubwayStation.getCount()
                        + ",B站车:" + YellowCycleUtil.bSubwayStation.getCount()
                        + ",c站车" + YellowCycleUtil.cSubwayStation.getCount());
                // A货车初始化
                Way randomWayA = YellowCycleUtil.randomWay();
                Truck truckA = new Truck(randomWayA, randomWayA.getOriginSubwayStation(), randomWayA.getDestSubwayStation(), second);
                setLoadCapacity(randomWayA, truckA);

                // B货车初始化
                Way randomWayB = YellowCycleUtil.randomWay();
                Truck truckB = new Truck(randomWayB, randomWayB.getOriginSubwayStation(), randomWayB.getDestSubwayStation(), second);
                setLoadCapacity(randomWayB, truckB);

                truckList.add(truckA);
                truckList.add(truckB);
            }
            Thread.sleep(1000);

            // 表示乘客随机的选择一个地铁站
            int randomSubway = YellowCycleUtil.randomGenerator(3);
            SubwayStation randomSubwayStation = YellowCycleUtil.subwayMap.get(randomSubway);
            int randomCapacity = randomSubwayStation.getCount();
            // 新增一位乘客所以某站需要减去一个小黄车
            randomSubwayStation.setCount(randomCapacity - 1);

            // 由于乘客的路线也是随机的，因此需要从路线库随机选择一条，如果在实际生活中，必然是乘客来选择起点和终点，然后再计算起点和终点之间的距离
            List<Way> randomWayList = YellowCycleUtil.wayHashMap.get(randomSubway);
            // 根据列表的大小随机产生一个路线
            int index = YellowCycleUtil.randomGenerator(randomWayList.size());
            Way randomWay = randomWayList.get(index - 1);
            Passenger passenger = new Passenger(randomWay, second, randomWay.getOriginSubwayStation(), randomWay.getDestSubwayStation());
            passengerList.add(passenger);
            int wayCount = handlePassengerList(passengerList, second);
            String truckStr = handleTruckList(truckList, second);

            System.out.println("第" + second + "秒,A站车:" + YellowCycleUtil.aSubwayStation.getCount() + ",B站车:"
                    + YellowCycleUtil.bSubwayStation.getCount() + ",c站车" + YellowCycleUtil.cSubwayStation.getCount()
                    + ",路上的车" + wayCount + "," + truckStr);
        }
    }


    /**
     * 因为每秒乘客会行驶一格子，所以每秒需要遍历所有的乘客，并且修改所有的乘客的状态,并且返回乘客链表中的小黄车数量，表示路上的车的数量
     */
    public static int handlePassengerList(List<Passenger> passengerList, int nowSecond) {
        //当前的秒数与乘客的启动时间之差等于乘客走的路径的距离时，便可以删除链表中的数据，说明其已经到达了终点，同时终点地铁站需要加一
        passengerList.removeIf(passenger -> {
            if ((nowSecond - passenger.getStartTime()) * passenger.getSpeed() == passenger.getDistance()) {
                SubwayStation destSubwayStation = passenger.getDestSubwayStation();
                int destCapacity = destSubwayStation.getCount();
                destSubwayStation.setCount(destCapacity + 1);
                return true;
            }
            return false;
        });
        return passengerList.size();
    }

    /**
     * @Description: 处理两辆货车的逻辑，由于货车需要需要在不同地铁站之间进行运输，所以基本逻辑与乘客类似，
     * 但是货车是不会消失的，所以需要在到达终点的时候，重新对货车的状态进行修改，而且货车的出发点除了初始化的时候
     * 是完全随机的路线外，在其他的时候都是根据他的上一个终点节点相关的。所以也是和乘客不同的逻辑的地方.
     * <p>
     * 从题目中可得到，货车的路线是随机的，而且货车有两辆，两辆车的路线也是随机的，要想能够完全满足乘客，则尽量保证三个车站的车的数量尽量平均即可解决
     * 乘客的需求，因此在货车运行的过程中，所以我们只需要满足货车终点与起点的地铁站的数量尽量相等即可满足小黄车对于乘客的需求
     */
    public static String handleTruckList(List<Truck> trucklist, int nowSecond) {
        StringBuilder sb = new StringBuilder();
        trucklist.forEach(a -> {
            // 当货车到达某个地铁站时，所在的地铁站的小黄车数量需要增加货车拉来的一部分，同时货车的运输量清空
            if ((nowSecond - a.getStartTime()) * a.getSpeed() >= a.getDistance()) {
                int count = a.getDestSubwayStation().getCount();
                a.getDestSubwayStation().setCount(count + a.getLoadCapacity());
                // 到达目的地后即将货车的运输量清空
                a.setLoadCapacity(0);
                // 此时货车卸完货后，将会把当前的终点地铁站当作起点继续运货,需要重新设置货车的状态属性
                // 首先获取id
                int id = a.getDestSubwayStation().getId();
                List<Way> randomWayList = YellowCycleUtil.wayHashMap.get(id);
                // 根据列表的大小随机产生一个路线
                int index = YellowCycleUtil.randomGenerator(randomWayList.size());
                Way randomWay = randomWayList.get(index - 1);

                a.setWay(randomWay);
                a.setOriginSubwayStation(randomWay.getOriginSubwayStation());
                a.setDestSubwayStation(randomWay.getDestSubwayStation());
                a.setStartTime(nowSecond);
                // 由于在构造函数中，默认使用了路线的距离，所以这里需要显示的使用路线的距离来设置货车的需要行驶的距离
                a.setDistance(randomWay.getDistance());
                // 这里设置货车的本次的运送量
                setLoadCapacity(randomWay, a);
            }
            if (a.getLoadCapacity() != 0) {
                sb.append(a.getOriginSubwayStation().getName()).append("-").append(a.getDestSubwayStation().getName())
                        .append("运输了").append(a.getLoadCapacity()).append(",");
            }
        });
        return sb.toString();
    }


    private static void setLoadCapacity(Way randomWay, Truck truck) {
        if (randomWay.getDestSubwayStation().getCount() < randomWay.getOriginSubwayStation().getCount()) {
            // 货车每次的运输量，两个地铁站的小黄车和的平均数减去终点地铁站的小黄车的数量，如果大于20，则按照20处理
            int originCount = randomWay.getOriginSubwayStation().getCount();
            int destCount = randomWay.getDestSubwayStation().getCount();

            int tempTruckLoadCapacity = (destCount + originCount) / 2 - destCount;
            int truckLoadCapacity = Math.min(tempTruckLoadCapacity, 20);
            truck.setLoadCapacity(truckLoadCapacity);
            randomWay.getOriginSubwayStation().setCount(originCount - truckLoadCapacity);
        }
    }

}
