package com.example.user_authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserDto {
    private Long id;            // User ID
    private String userName;    // Username
    private String passWord;    // Hashed password
    private boolean isActive;   // user is active by default
    private LocalDateTime lastLogin; //login date and time
    private String role;        // Role of the user

    // No-argument constructor
    public UserDto() {
    }

    // All-argument constructor
    public UserDto(Long id, String userName, String passWord, boolean isActive, LocalDateTime lastLogin, String role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.isActive = isActive;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Setter for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter for passWord
    public String getPassWord() {
        return passWord;
    }

    // Setter for passWord
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    // Getter for isActive
    public boolean isActive() {
        return isActive;
    }

    // Setter for isActive
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Getter for lastLogin
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    // Setter for lastLogin
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }

}
