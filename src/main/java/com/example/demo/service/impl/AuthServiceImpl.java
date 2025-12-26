package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(AuthRequestDto request) {
        if ("admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @Override
    public String register(RegisterRequestDto request) {
        return "User registered successfully";
    }
}
