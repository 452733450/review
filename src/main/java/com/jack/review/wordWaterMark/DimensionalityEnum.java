package com.jack.review.wordWaterMark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author zhangwei@meix.com
 * @date 2020/11/7
 */
@Getter
@AllArgsConstructor
public enum DimensionalityEnum {

    // 产品要素导出维度
    PRODUCT(1, "按产品维度导出"),
    FILE_TYPE(2, "按文件类型导出");

    private Integer codeValue;

    private String codeText;

    public static DimensionalityEnum getInstance(Integer type) {
        DimensionalityEnum[] values = DimensionalityEnum.values();
        for (DimensionalityEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static DimensionalityEnum getInstance(String codeText) {
        DimensionalityEnum[] values = DimensionalityEnum.values();
        for (DimensionalityEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        DimensionalityEnum[] values = values();
        for (DimensionalityEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        DimensionalityEnum[] values = values();
        for (DimensionalityEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
