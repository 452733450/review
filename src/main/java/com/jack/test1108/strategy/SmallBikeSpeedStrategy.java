package com.jack.test1108.strategy;

public class SmallBikeSpeedStrategy implements SpeedStrategy {
    @Override
    public int getSpeed() {
        // 返回小黄车的速度
        return 1;
    }
}
