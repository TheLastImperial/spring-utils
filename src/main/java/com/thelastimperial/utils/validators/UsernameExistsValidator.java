package com.thelastimperial.utils.validators;

import com.thelastimperial.utils.annotations.UsernameExists;
import com.thelastimperial.utils.services.UsernameService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String>{
    private final UsernameService usernameService;

    public UsernameExistsValidator(UsernameService usernameService){
        this.usernameService = usernameService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return usernameService.findByUsername(value).isEmpty();
    }

}
