package com.jack.pokerGame.strategy.impl;


import com.jack.pokerGame.enums.CardValueEnum;
import com.jack.pokerGame.strategy.CardValueStrategy;

/**
 * 自定义纸牌分值策略
 */
public class CustomValueStrategy implements CardValueStrategy {
    @Override
    public Integer getValue(String rank) {
        if (CardValueEnum.parse(rank) != null) {
            return CardValueEnum.parse(rank);
        }
        return 0;
    }
}
