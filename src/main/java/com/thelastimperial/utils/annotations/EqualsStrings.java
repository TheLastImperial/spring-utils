package com.thelastimperial.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.EqualsStringsValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 *
 * EqualsStrings Validate two Object properties that have to have the same value.
*/
@Constraint(validatedBy = EqualsStringsValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EqualsStrings {
    /**
     *
     * @return the first property to validate.
    */
    String field();
    /**
     *
     * @return the second property to validate.
    */
    String fieldMatch();
    /**
     * Error message when the fields values are not the same.
     *
     * @return The message.
    */
    String message() default "Strings values do not match!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
