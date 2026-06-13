package com.nara.auth_service.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

  @Value("${jwt.token.secret}")
  private String secretKey;
  SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

  public String generateToken(UserDetails authUser) {

    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder()
        .subject(authUser.getUsername())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 80 * 30))
        .signWith(key)
        .compact();
  }

  public Claims jwtParser(String token) {

    return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();

  }

  public String getUsername(String token) {
    return (String) jwtParser(token).getSubject();
  }

  public boolean isExpired(String token) {
    return jwtParser(token).getExpiration().before(new Date());
  }

  public boolean validateToken(String username, String token, UserDetails userDetails) {
    return username.equals(getUsername(token)) && !isExpired(token);
  }

}
