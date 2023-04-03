package com.jack.normal;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 投资者信息
 *
 * @author jack
 * @since 2023-02-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonFilter("myFilter")
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投资者名称
     */
    @BusinessType
    private String customerName;

    /**
     * 投资者风险等级：C1~C5：1~5
     */
    @BusinessType(businessType = 1)
    private Integer riskType;

    /**
     * 是否适用冷静期(1:是，0：否)
     */
    @BusinessType(businessType = 1)
    private Integer isNeedCoolingPeriod;

}
