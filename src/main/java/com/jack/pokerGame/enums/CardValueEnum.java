package com.jack.pokerGame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 纸牌分值枚举
 */
@Getter
@AllArgsConstructor
public enum CardValueEnum {

    CARD_1("1", 1),
    CARD_2("2", 2),
    CARD_3("3", 3),
    CARD_4("4", 4),
    CARD_5("5", 5),
    CARD_6("6", 6),
    CARD_7("7", 7),
    CARD_8("8", 8),
    CARD_9("9", 9),
    CARD_10("10", 10),
    CARD_J("11", 11),
    CARD_Q("12", 12),
    CARD_K("13", 13),
    CARD_BIG_KING("20K", 20),
    CARD_SMALL_KING("20Q", 20);

    /**
     * 牌面值 (A、2、3、4、5、6、7、8、9、10、J、Q、K)分别被记为 1、2、3、4、5、6、7、8、9、10、11、12、13，大王20K,小王20Q
     */
    private String rank;

    /**
     * 纸牌分值,其中1-10各种花色的纸牌分别为 1-10.J、Q、K分别被记为 11.12.13，大王和小王分别记为 20
     */
    private Integer value;


    public static CardValueEnum getInstance(Integer type) {
        CardValueEnum[] values = CardValueEnum.values();
        for (CardValueEnum value : values) {
            if (type.intValue() == value.getValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static CardValueEnum getInstance(String rank) {
        CardValueEnum[] values = CardValueEnum.values();
        for (CardValueEnum value : values) {
            if (Objects.equals(rank, value.getRank())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        CardValueEnum[] values = values();
        for (CardValueEnum value : values) {
            if (value.getValue().equals(codeValue)) {
                return value.getRank();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        CardValueEnum[] values = values();
        for (CardValueEnum value : values) {
            if (value.getRank().equals(StringUtils.trim(codeText))) {
                return value.getValue();
            }
        }
        return null;
    }
}
