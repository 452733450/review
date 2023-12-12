package com.jack.test1108.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alert implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 报警编号
     */
    private String alertId;

    /**
     * 报警应用号
     */
    private String appCode;

    /**
     * 报警服务器IP
     */
    private String ip;

    /**
     * 报警详情
     */
    private String alertDetail;

    /**
     * 报警原因
     */
    private String cause;

    /**
     * 报警建议解决方案
     */
    private String solution;

    /**
     * 部署区域
     */
    private String zone;

    /**
     * 处理状态（0：未处理，1：已处理）
     */
    private Integer status;
}
