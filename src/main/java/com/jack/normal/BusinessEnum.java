package com.jack.normal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 业务类型：1：认购 2:申购，3：赎回
 *
 * @author zhangwei@meix.com
 * @date 2020/11/7
 */
@Getter
@AllArgsConstructor
public enum BusinessEnum {

    SUBSCRIBE(1, "认购"),
    SUBSCRIBE_TO(2, "申购"),
    REDEEM(3, "赎回");

    private Integer codeValue;

    private String codeText;

    public static com.jack.normal.BusinessEnum getInstance(Integer type) {
        com.jack.normal.BusinessEnum[] values = com.jack.normal.BusinessEnum.values();
        for (com.jack.normal.BusinessEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static com.jack.normal.BusinessEnum getInstance(String codeText) {
        com.jack.normal.BusinessEnum[] values = com.jack.normal.BusinessEnum.values();
        for (com.jack.normal.BusinessEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        com.jack.normal.BusinessEnum[] values = values();
        for (com.jack.normal.BusinessEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        com.jack.normal.BusinessEnum[] values = values();
        for (com.jack.normal.BusinessEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
