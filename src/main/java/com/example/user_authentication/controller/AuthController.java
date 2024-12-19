package com.example.user_authentication.controller;

import com.example.user_authentication.dto.LoginRequestDto;
import com.example.user_authentication.dto.LoginResponseDto;
import com.example.user_authentication.service.AuthService;
import com.example.user_authentication.utility.JwtUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;
    @PostMapping("login")
    public ResponseEntity<String> login(@Validated @RequestBody LoginRequestDto loginRequest, HttpServletRequest request){
        String clientIp=request.getRemoteAddr();
        LoginResponseDto response = service.authenticateUser(loginRequest);
        if (response.getIsSuccessful()) {
            String token = JwtUtility.generateToken(loginRequest.getUserName(),response.getRole(),clientIp);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
