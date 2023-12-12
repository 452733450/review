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
public class Col implements Serializable {

    private static final long serialVersionUID = 1L;

    //字段名
    private String colName;
    //字段类型
    private String colType;
}
