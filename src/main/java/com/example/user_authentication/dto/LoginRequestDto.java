package com.example.user_authentication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank
    private String userName;
    @NotBlank
    private String passWord;

    // No-argument constructor
    public LoginRequestDto() {
    }

    // All-argument constructor
    public LoginRequestDto(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
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
}
