package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String register(RegisterRequestDto dto) {
        return "User registered: " + dto.getUsername();
    }

    // ✅ REQUIRED METHOD
    @Override
    public String login(AuthRequestDto dto) {
        return "Login successful for: " + dto.getUsername();
    }
}
