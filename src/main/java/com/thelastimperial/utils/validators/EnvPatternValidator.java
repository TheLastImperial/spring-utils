package com.thelastimperial.utils.validators;

import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;

import com.thelastimperial.utils.annotations.EnvPattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnvPatternValidator implements ConstraintValidator<EnvPattern, String>{
    private final Log log = LogFactory.getLog(EnvPatternValidator.class);
    private final Environment env;
    private Pattern pattern;

    public EnvPatternValidator(Environment env) {
        this.env = env;
    }

    @Override
    public void initialize(EnvPattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        String property = constraintAnnotation.property();
        if(property.isEmpty()){
            log.error("The property is empty.");
            throw new RuntimeException("You must set a property value");
        }
        String patternStr = env.getProperty(property);
        if(patternStr == null){
            log.error("The property doesn't exists.");
            throw new RuntimeException("The Property " + property + " doesn't exists.");
        }
        log.debug("Property Name: " + property);
        log.debug("Property Value: " + patternStr);
        pattern = Pattern.compile(patternStr);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = pattern.matcher(value).matches();
        log.debug("Value received: " + value);
        log.debug("Result: " + result);

        return result;
    }

    
}
