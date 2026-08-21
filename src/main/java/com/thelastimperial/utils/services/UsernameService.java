package com.thelastimperial.utils.services;

import java.util.Optional;

import com.thelastimperial.utils.entities.Username;

public interface UsernameService {
    public Optional<? extends Username> findByUsername(String username);
}
