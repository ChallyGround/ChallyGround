/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 로그인 컨트롤러
***/
package com.chally.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chally.main.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
    @GetMapping("/api/login")
    @ResponseBody
    public String login(Authentication authentication) {
    	String plain = loginService.getLogin(authentication);
    	
    	return plain;
    }
}