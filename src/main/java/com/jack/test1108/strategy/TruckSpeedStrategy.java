package com.jack.test1108.strategy;

public class TruckSpeedStrategy implements SpeedStrategy{
    @Override
    public int getSpeed() {
        // 返回货车的速度
        return 3;
    }
}
