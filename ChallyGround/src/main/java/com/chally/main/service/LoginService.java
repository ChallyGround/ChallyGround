package com.chally.main.service;

import org.springframework.stereotype.Service;

import com.chally.dao.UserInfoMapper;
import com.chally.vo.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Service
public class LoginService {
	@Autowired
	UserInfoMapper userInfoDao;

	public String getLogin(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof OAuth2User) {
            // 파라미터 받기
            OAuth2User oauth2User = (OAuth2User) principal;
            String sub = oauth2User.getAttribute("sub");
            String name = oauth2User.getAttribute("name");
            String email = oauth2User.getAttribute("email");
            
            //VO 객체 생성
            UserInfo record = new UserInfo();
            record.setEmail(email);
            record.setName(name);
            record.setOauthId(sub);
            
            //DAO 실행
            int checked = 0;
            int isSignUp = userInfoDao.searchOneCount(record); // 회원가입 체크
            if(isSignUp < 1) {
            	checked = userInfoDao.insertSelective(record);
            	isSignUp = 1;
            }
            
            return (isSignUp == 1) ? 
            		"Welcome, " + name + "! Your email is: " + email :  
            		"Welcome, authenticated user!" ;
        } else {
            return "Welcome, authenticated user!";
        }
	}
}