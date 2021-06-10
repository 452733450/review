package com.jack.review.test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/13/10:51
 */
public class DecimalDigitsValidator implements ConstraintValidator<DecimalDigits, BigDecimal> {

    private DecimalDigits decimalDigits;

    private static final String REG = "^(([1-9]\\d*)|([0]))(\\.(\\d){0," + "limit})?$";

    @Override
    public void initialize(DecimalDigits constraintAnnotation) {
        this.decimalDigits = constraintAnnotation;
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value != null) {
            int limit = decimalDigits.limit();
            Pattern pattern = Pattern.compile(REG.replace("limit", String.valueOf(limit)));

            Matcher match = pattern.matcher(value.toString());
            return match.matches();
        } else {
            return true;
        }
    }
}
