package com.jack.pokerGame;

import com.jack.pokerGame.entity.Card;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class CardComparator implements Comparator<Card> {
    private Map<String, Integer> suitRank = new HashMap<>();

    public CardComparator() {
        suitRank.put("20K", 6); // 大王
        suitRank.put("20Q", 5); // 小王
        suitRank.put("D", 4); // 黑桃
        suitRank.put("C", 3); // 红桃
        suitRank.put("B", 2); // 梅花
        suitRank.put("A", 1); // 方片
    }

    @Override
    public int compare(Card card1, Card card2) {
        if (!Objects.equals(card1.getValue(), card2.getValue())) {
            return card2.getValue() - card1.getValue();
        }
        return suitRank.get(card2.getSuit()) - suitRank.get(card1.getSuit());
    }
}

