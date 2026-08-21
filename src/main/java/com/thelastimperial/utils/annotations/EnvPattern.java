package com.thelastimperial.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.EnvPatternValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnvPatternValidator.class)
public @interface EnvPattern {
    String message() default "Invalid pattern.";
    String property() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
