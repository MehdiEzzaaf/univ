package com.gestion1.univ.services;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleAuthenticationServiceimp implements AuthenticationService {

    // Simulated database of users and passwords
    private Map<String, String> userCredentials = new HashMap<>();

    public SimpleAuthenticationServiceimp() {
        // Populate the user credentials (this would typically come from a database)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        // Add more users as needed
    }

    @Override
    public boolean authenticate(String username, String password) {
        // Check if the provided username exists and the password matches
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}

