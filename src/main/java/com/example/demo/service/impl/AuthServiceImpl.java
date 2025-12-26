package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;

    public AuthServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public String login(AuthRequestDto dto) {
        return "TOKEN";
    }

    public void register(RegisterRequestDto dto) {
        repo.save(new User(dto.getUsername(), dto.getPassword()));
    }
}
