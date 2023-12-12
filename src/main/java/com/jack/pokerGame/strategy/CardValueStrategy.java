package com.jack.pokerGame.strategy;

/**
 * 纸牌分值策略接口
 */
public interface CardValueStrategy {
    /**
     * 获取纸牌分值
     *
     * @param rank 纸牌名称
     * @return 纸牌分值
     */
    Integer getValue(String rank);
}
