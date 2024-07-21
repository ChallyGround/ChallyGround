package com.chally.main.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(Authentication authentication) {
    	
        Object principal = authentication.getPrincipal();
        if (principal instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) principal;
            // OAuth2User에서 사용자의 정보 얻기
            String name = oauth2User.getAttribute("name");
            String email = oauth2User.getAttribute("email");

            return "Welcome, " + name + "! Your email is: " + email;
        } else {
            // 일반적인 경우
            return "Welcome, authenticated user!";
        }
    }
    
    
}