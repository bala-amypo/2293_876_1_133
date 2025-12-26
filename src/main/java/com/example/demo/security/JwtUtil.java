package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final long EXPIRATION = 1000 * 60 * 60;

    public String generateToken(String username) {
        return username + "_token";
    }

    public boolean isTokenValid(String token, String username) {
        return token != null && token.startsWith(username);
    }

    public long getExpirationMillis() {
        return EXPIRATION;
    }
}
