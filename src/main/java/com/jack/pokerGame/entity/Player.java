package com.jack.pokerGame.entity;

import com.jack.pokerGame.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 玩家类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 玩家姓名
     */
    private String name;

    /**
     * 手牌
     */
    private List<Card> hand;

    /**
     * 得分
     */
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public void increaseScore(int points) {
        score += points;
    }

}
