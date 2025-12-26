package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(AuthRequestDto request) {
        return "Login successful";
    }

    @Override
    public String register(RegisterRequestDto request) {
        return "User registered successfully";
    }
}
