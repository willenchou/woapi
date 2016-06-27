package com.willen.openapi.validation.validator;

import com.willen.openapi.validation.LessThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 小于值注解验证器
 *
 * @author willen
 *
 */
public class LessThanValidator implements ConstraintValidator<LessThan, Integer> {

    private Integer value;

    @Override
    public void initialize(LessThan constraintAnnotation) {
        value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value < this.value;
    }
}
