package com.example.user_authentication.service;

import com.example.user_authentication.dto.LoginRequestDto;
import com.example.user_authentication.dto.LoginResponseDto;
import com.example.user_authentication.dto.UserDto;
import com.example.user_authentication.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtility jwtUtility;
    private  String userRegisterServiceUrl="http://localhost:8081"; // Base URL of the User Registration Microservice

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginResponseDto authenticateUser(LoginRequestDto loginRequest) {
        // Step 1: Build the URL to fetch user details from the User Registration Microservice
        // Communicate with the User Registration Microservice
        String url= userRegisterServiceUrl+"/users/"+loginRequest.getUserName();
        try {
            // Step 2: Make an HTTP GET request to fetch user details
            ResponseEntity<UserDto> response = restTemplate.getForEntity(url, UserDto.class);

            // Step 3: Check if user is found
            if ( response.getBody() != null) {
                UserDto user = response.getBody();

                // Step 4: Compare the entered password with the hashed password
                if (passwordEncoder.matches(loginRequest.getPassWord(), user.getPassWord())) {
                    // Step 5: If successful, return the role and success status
                    return new LoginResponseDto(true, user.getRole());
                }
            }
        } catch (Exception e){
                // Log the error for debugging
                System.out.println("Error during authentication: " + e.getMessage());
            }

        // Step 6: If authentication fails, return unsuccessful response
        return new LoginResponseDto(false, null);
        }
    }

