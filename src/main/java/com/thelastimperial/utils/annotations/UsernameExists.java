package com.thelastimperial.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.thelastimperial.utils.validators.UsernameExistsValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 *
 * UsernameExists Validate that a username doesn't exists.
*/
@Constraint(validatedBy = UsernameExistsValidator.class )
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UsernameExists {
    /**
     * Message error.
     *
     * @return Message error.
    */
    String message() default "Username already exists.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
