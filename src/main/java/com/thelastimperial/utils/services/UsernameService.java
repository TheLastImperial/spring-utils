package com.thelastimperial.utils.services;

import java.util.Optional;

import com.thelastimperial.utils.entities.Username;
/**
 * Service interface to get a object that extends Username interface this garanty
 * that have a method getUsername.
 * UsernameService
*/
public interface UsernameService {
    /**
     * Find a T by his username.
     * @param username The String used to search.
     * @return And Optional object that implements
     * {@link com.thelastimperial.utils.entities.Username}
    */
    public Optional<? extends Username> findByUsername(String username);
}
