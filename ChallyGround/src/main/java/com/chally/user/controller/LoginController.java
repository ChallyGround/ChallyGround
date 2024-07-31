/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 로그인 컨트롤러
***/
package com.chally.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chally.config.JwtUtil;
import com.chally.user.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/api/login")
	public String login(Authentication authentication) {
        String email = loginService.getLogin(authentication); //E-mail 반환
        String token = jwtUtil.generateToken(email);
        try {
            String encodedToken = URLEncoder.encode(token, "UTF-8");
            return "redirect:http://localhost:8080/login-success?token=" + encodedToken;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/";
        }
	}
}