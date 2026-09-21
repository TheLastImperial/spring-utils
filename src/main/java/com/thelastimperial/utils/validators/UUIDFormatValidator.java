package com.thelastimperial.utils.validators;

import com.thelastimperial.utils.UUIDUtils;
import com.thelastimperial.utils.annotations.UUIDFormat;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 *
 * UUIDFormatValidator validate the string format with UUIDUtils
*/
public class UUIDFormatValidator implements ConstraintValidator<UUIDFormat, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return UUIDUtils.isValid(value);
    }

}
