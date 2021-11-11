package com.jack.review.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/06/11:08
 */
@Data
@Validated
@Builder
@AllArgsConstructor
public class User implements Serializable {

    private Integer age;

    @NotNull(message = "用户名不能为空")
    private String name;

    private BigDecimal money;
}
