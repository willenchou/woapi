package com.willen.openapi.validation.validator;

import com.willen.openapi.validation.EqualLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 等于长度注解验证器
 *
  * @author willen
 *
 */
public class EqualLengthValidator implements ConstraintValidator<EqualLength, String> {

    private int length;

    @Override
    public void initialize(EqualLength constraintAnnotation) {
        length = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() == length;
    }
}
