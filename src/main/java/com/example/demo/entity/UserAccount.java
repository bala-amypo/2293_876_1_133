package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fullName;
    private String password;
    private String role;

    private Date createdAt;
    private Date updatedAt;

    public UserAccount() {}

    public UserAccount(String email, String fullName, String password, String role) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Called automatically before inserting new record
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    // Called automatically before updating existing record
    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
}
