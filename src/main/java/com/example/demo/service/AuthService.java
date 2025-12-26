package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto dto);

    // ✅ REQUIRED FOR TEST + CONTROLLER
    String login(AuthRequestDto dto);
}
