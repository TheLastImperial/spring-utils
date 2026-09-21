package com.thelastimperial.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.UUIDFormatValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 *
 * UUIDFormat validate a string with a UUID format.
*/
@Constraint(validatedBy = UUIDFormatValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UUIDFormat {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Invalid format.";
}
