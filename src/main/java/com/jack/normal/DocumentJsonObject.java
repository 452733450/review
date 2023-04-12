package com.jack.normal;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 签署流程文件存储信息对象，对应表中的json对象
 * @Author: wys
 * @Date: 2020/5/13
 */
@Data
public class DocumentJsonObject implements Serializable {

    private String originUrlWord;

    private String originUrlPbWord;

    /**
     * 原始pdf文件路径
     */
    private String originUrlPdf;

    /**
     * 用印后pdf文件路径
     */
    private String signUrlPdf;

    /**
     * 签署信息
     */
    private List<SignInfo> signInfo;

    /**
     * 用印后pdf文件切割成jpg后图片路径
     */
    private String originImgsPath;

    /**
     * 原始pdf文件切割成jpg后图片路径
     */
    private String originOldImgsPath;

    /**
     * jpg图片页数
     */
    private String pdfPageNums;

    /**
     * 文件名称
     */
    private String DocumentName;

    private String pbSignEUrl;

    private Integer PbarDoSign;

    private Integer PboDosign;

    /**
     * 操作留痕文件路径
     */
    private String markedPdfPath;

    private Long attachmentsId;

    private String rawPageWidth;

    private String rawPageHeight;

    private Integer customerIsManager = 0;

}
