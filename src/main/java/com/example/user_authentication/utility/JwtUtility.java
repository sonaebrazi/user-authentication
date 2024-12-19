package com.example.user_authentication.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyFactory;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtility {

    private static final String SECRET_KEY = "pMw8hUNJ+MgGVbFtNkYFxThqlRtOAs59gQaIkvlxlNc=";

    private static Key getKeyFromSecret() {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static String generateToken(String username, String role, String ip) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("ip", ip)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Token valid for 1 hour
                .signWith(getKeyFromSecret())
                .compact();
    }

    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKeyFromSecret())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
