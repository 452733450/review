package com.jack.normal;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BusinessType {

    /**
     * 字段属于何种交易类型：1：认申购， 3：赎回， 0：都属于
     */
    int businessType() default 0;
}
