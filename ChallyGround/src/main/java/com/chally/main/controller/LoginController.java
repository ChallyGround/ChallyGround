/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 로그인 컨트롤러
***/
package com.chally.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chally.config.JwtUtil;
import com.chally.main.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/api/login")
	@ResponseBody
	public String login(Authentication authentication) {
		String username = loginService.getLogin(authentication);
		String token = jwtUtil.generateToken(username);
		return "redirect:/login-success?token=" + token;
	}
}