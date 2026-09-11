package com.thelastimperial.utils.validators;

import com.thelastimperial.utils.annotations.UsernameExists;
import com.thelastimperial.utils.services.UsernameService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 *
 * UsernameExistsValidator Validate that the username don't exists.
*/
public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String>{
    /**
     * Service used to validate that already exists.
    */
    private final UsernameService usernameService;

    public UsernameExistsValidator(UsernameService usernameService){
        this.usernameService = usernameService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return usernameService.findByUsername(value).isEmpty();
    }

}
