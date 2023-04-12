package com.jack.normal;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 流程签署文件用印及签名信息对象
 * @Author: wys
 * @Date: 2020/5/13
 */
@Data
public class SignInfo implements Serializable {

    private String signType;

    private String signType_child;

    private String pageNum;

    private int positionTop;

    private int positionLeft;

    private String signContent;

    private String investerType;

    private String lineWidth;

    private String height;

    private String width;

    private Long customerId;

    private int isFinishSeal;

}
