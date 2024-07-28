package com.chally.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {    
    @PostMapping("/api/submit")
    public ResponseEntity<Map<String, String>> submitData(@RequestBody Map<String, String> request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 로그인된 유저 정보 확인 가능
        String name = request.get("name");
        String email = request.get("email");

        // 비즈니스 로직 처리 (예: 데이터베이스에 저장 등)
        

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("name", name);
        response.put("email", email);

        return ResponseEntity.ok(response);
    }
}