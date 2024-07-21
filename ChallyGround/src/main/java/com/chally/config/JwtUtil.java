package com.chally.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); 
    private final long expirationTime = 864_000_00; // 1 day

    // 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey) // `signWith` 메소드의 첫 번째 인자가 `Key` 객체
                .compact();
    }

    // 토큰에서 사용자 이름 추출
//    public String extractUsername(String token) {
//        return parseClaims(token).getSubject();
//    }

    // 토큰에서 Claims 추출
//    private Claims parseClaims(String token) {
//        return Jwts.builder() // `parser()` 대신 `parserBuilder()` 사용
//                .setSigningKey(secretKey) // 서명 키 설정
//                .build()
//                .parseClaimsJws(token) // JWT에서 Claims 추출
//                .getBody();
//    }
}