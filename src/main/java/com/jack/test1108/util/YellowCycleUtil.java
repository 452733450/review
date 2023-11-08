package com.jack.test1108.util;

import com.jack.test1108.model.Location;
import com.jack.test1108.model.SubwayStation;
import com.jack.test1108.model.Way;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description:小黄车工具类
 */
public final class YellowCycleUtil {

    public static final Map<Integer, SubwayStation> subwayMap = new HashMap<>();
    //初始化地铁站的相关数据信息
    public static final SubwayStation aSubwayStation = new SubwayStation(1, 30, new Location("a", 1), "A");
    public static final SubwayStation bSubwayStation = new SubwayStation(2, 40, new Location("h", 8), "B");
    public static final SubwayStation cSubwayStation = new SubwayStation(3, 30, new Location("d", 3), "C");

    //此处主要是获取从不同的地铁站出发的路线映射
    //优化方案:可以使用深度优先遍历的方法自动获取到对应的路线，然后再随机选取一条
    public static final Map<Integer, List<Way>> wayHashMap = new HashMap<>();
    //以A地铁站为起点的路线
    public static final List<Way> aWayList = new ArrayList<>();
    //以B地铁站为起点的路线
    public static final List<Way> bWayList = new ArrayList<>();
    //以C地铁站为起点的路线
    public static final List<Way> cWayList = new ArrayList<>();

    static {
        //此处将车站于数字一一映射，为了达到乘客随机选择的目的
        subwayMap.put(1, aSubwayStation);
        subwayMap.put(2, bSubwayStation);
        subwayMap.put(3, cSubwayStation);
        //以A地铁站为起点的路线
        aWayList.add(new Way(YellowCycleUtil.aSubwayStation, YellowCycleUtil.bSubwayStation, 14));
        aWayList.add(new Way(YellowCycleUtil.aSubwayStation, YellowCycleUtil.cSubwayStation, 5));
        aWayList.add(new Way(YellowCycleUtil.aSubwayStation, YellowCycleUtil.cSubwayStation, 21));
        //以B地铁站为起点的路线
        bWayList.add(new Way(YellowCycleUtil.bSubwayStation, YellowCycleUtil.aSubwayStation, 14));
        bWayList.add(new Way(YellowCycleUtil.bSubwayStation, YellowCycleUtil.cSubwayStation, 9));
        //以C地铁站为起点的路线
        cWayList.add(new Way(YellowCycleUtil.cSubwayStation, YellowCycleUtil.bSubwayStation, 9));
        cWayList.add(new Way(YellowCycleUtil.cSubwayStation, YellowCycleUtil.aSubwayStation, 5));
        cWayList.add(new Way(YellowCycleUtil.cSubwayStation, YellowCycleUtil.aSubwayStation, 21));
        //地铁站与路线的映射
        wayHashMap.put(1, aWayList);
        wayHashMap.put(2, bWayList);
        wayHashMap.put(3, cWayList);
    }

    /**
     * 表示去掉随机数中产生的0
     */
    private static final int DELETE_ZERO = 1;

    /**
     * 生成0~bound范围内的随机整数
     */
    public static int randomGenerator(int bound) {
        return ThreadLocalRandom.current().nextInt(bound) + DELETE_ZERO;
    }

    /**
     * 货车初始化的时候，随机产生一条路线
     */
    public static Way randomWay() {
        int randomSubway = YellowCycleUtil.randomGenerator(3);
        // 由于乘客的路线也是随机的，因此需要从路线库随机选择一条，如果在实际生活中，必然是乘客来选择起点和终点，然后再计算起点和终点之间的距离
        List<Way> randomWayList = wayHashMap.get(randomSubway);
        // 根据列表的大小随机产生一个路线
        int index = YellowCycleUtil.randomGenerator(randomWayList.size());
        return randomWayList.get(index - 1);
    }


}
