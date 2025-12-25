package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);

    UserAccount getUserByEmail(String email);

    List<UserAccount> getAllUsers();
}
