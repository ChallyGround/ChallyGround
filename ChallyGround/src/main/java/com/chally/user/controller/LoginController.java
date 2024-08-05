/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 로그인 컨트롤러
***/
package com.chally.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chally.component.JwtUtil;
import com.chally.user.service.LoginService;

@Controller
public class LoginController {
    @Value("${service.ip}")
    private String allowedOrigins;
    
	@Autowired
	LoginService loginService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/axios/login")
	public String login(Authentication authentication) {
        String email = loginService.getLogin(authentication); //E-mail 반환
        String token = jwtUtil.generateToken(email);
        try {
            String encodedToken = URLEncoder.encode(token, "UTF-8");
            return "redirect:"+allowedOrigins+"/chally/login-success?token=" + encodedToken;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/";
        }
	}
	
    @GetMapping("/login")
    public String loginPage(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "로그인 실패. 사용자 이름이나 비밀번호를 확인하세요.");
        }
        return "login"; // login.html 템플릿 페이지로 반환
    }
}