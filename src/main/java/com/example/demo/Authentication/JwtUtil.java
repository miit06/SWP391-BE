package com.example.demo.Authentication;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "11b9b98c9cb6e37aa95315667049de896e9b39e14a06a6e9f8446a39d01c29f3ecf31a174be24e4d87dbc6473ef31e5358d0aba4075a2a49965298e794bd5dec506377938cdd26015e2ff1b126b568e470d0eaecad77ba38e5c68e5f3c264c48fed249fa6c7edf111b4150c5686ed3f21c0994d93759801eaacdf0ff9bb37c7b50212122d42cd5f41d1bbd1ae155df30bbf6f7800fed590db54c6904c4ec74419783f2bd97f0ef9854bb5a5051f5953416eab0f2b8c5c1fa0975242e5808086de07323189efd6328f2d4ed85a6ca593cb2fdd400df20f9996308939ed0d7366e5ac936bdbb24fc6bb6428208649994824a150a60b27bda009d5efeb7e572e3ab"; // Change this!
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}

