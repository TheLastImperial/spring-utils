package com.thelastimperial.utils.validators;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapperImpl;

import com.thelastimperial.utils.annotations.EqualsStrings;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 *
 * EqualsStringsValidator Validate two properties values from a object,
 * setting the properties names.
*/
public class EqualsStringsValidator implements ConstraintValidator<EqualsStrings, Object>{
    private final Log log = LogFactory.getLog(EqualsStringsValidator.class);

    /**
     * First property name to validate.
    */
    private String field;
    /**
     * Second property name to validate.
    */
    private String fieldMatch;
    /**
     * Message to display when the fields values are not the same.
    */
    private String message;

    @Override
    public void initialize(EqualsStrings constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
        this.message = constraintAnnotation.message();

        log.debug("Field Name: " + field);
        log.debug("FieldMatch Name: " + fieldMatch);
        if(this.field.isEmpty() || this.fieldMatch.isEmpty()){
            throw new RuntimeException("The fields cann't be empty");
        }
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        log.debug("Field Value: " + fieldValue);
        log.debug("FieldMatch Value: " + fieldMatchValue);

        context.buildConstraintViolationWithTemplate(message)
            .addPropertyNode(fieldMatch)
            .addConstraintViolation();

        if(fieldValue == null || fieldMatchValue == null){
            log.debug("Field or FieldMatch is null.");
            return false;
        }

        return fieldValue.equals(fieldMatchValue);
    }
}
