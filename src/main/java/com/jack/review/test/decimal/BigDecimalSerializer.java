package com.jack.review.test.decimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;


/**
 * @Description: @JsonSerialize(using = BigDecimalSerializer.class)
 * @Auther: Jack You
 * @Date: 2022/03/01/10:56
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            // 保留5位小数，四舍五入
            BigDecimal number = value.setScale(2, BigDecimal.ROUND_HALF_UP);
            gen.writeNumber(number);
        } else {
            gen.writeNumber((BigDecimal) null);
        }
    }
}
