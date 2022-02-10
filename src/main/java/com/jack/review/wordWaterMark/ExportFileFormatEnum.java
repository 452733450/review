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
public enum ExportFileFormatEnum {

    WORD(1, "导出word"),
    PDF(2, "导出pdf"),
    WORD_AND_PDF(3, "导出word及pdf"),
    ;

    private Integer codeValue;

    private String codeText;

    public static ExportFileFormatEnum getInstance(Integer type) {
        ExportFileFormatEnum[] values = ExportFileFormatEnum.values();
        for (ExportFileFormatEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static ExportFileFormatEnum getInstance(String codeText) {
        ExportFileFormatEnum[] values = ExportFileFormatEnum.values();
        for (ExportFileFormatEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        ExportFileFormatEnum[] values = values();
        for (ExportFileFormatEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        ExportFileFormatEnum[] values = values();
        for (ExportFileFormatEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
