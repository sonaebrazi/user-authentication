package com.example.user_authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class LoginResponseDto {
    private Boolean isSuccessful;
    private String role;

    public LoginResponseDto(Boolean isSuccessful, String role) {
        this.isSuccessful = isSuccessful;
        this.role = role;
    }

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
