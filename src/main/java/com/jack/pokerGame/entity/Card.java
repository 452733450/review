package com.jack.pokerGame.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 纸牌类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 纸牌花色 (方片，梅花、红桃、黑桃)分别被记为 A、B、C、D
     */
    private String suit;

    /**
     * 牌面值 (A、2、3、4、5、6、7、8、9、10、J、Q、K)分别被记为 1、2、3、4、5、6、7、8、9、10、11、12、13，大王20K,小王20Q
     */
    private String rank;

    /**
     * 纸牌分值,其中1-10各种花色的纸牌分别为 1-10.J、Q、K分别被记为 11.12.13，大王和小王分别记为 20
     */
    private Integer value;
}
