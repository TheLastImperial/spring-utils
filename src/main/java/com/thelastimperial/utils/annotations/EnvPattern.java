package com.thelastimperial.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.EnvPatternValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * EnvPattern Annotation validator for a text that have to match a pattern that
 * come from a Property.
 *
*/
@Constraint(validatedBy = EnvPatternValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnvPattern {
    /**
     *
     * @return the message for the error.
    */
    String message() default "Invalid pattern.";

    /**
     * Set the property to search to create the Pattern to validate.
    */
    String property() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
