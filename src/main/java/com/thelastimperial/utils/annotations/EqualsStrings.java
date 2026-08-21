package com.thelastimperial.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.EqualsStringsValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualsStringsValidator.class)
public @interface EqualsStrings {

    String field();
    String fieldMatch();

    String message() default "Strings values do not match!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
