/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.27
 *목적: 로그인 서비스
***/
package com.chally.user.service;

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

	/***
	 *메소드 용도: 회원가입&로그인
	 *매개변수: Authentication
	 *반환값: String(email)
	***/
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
            int isSignUp = userInfoDao.searchOneCount(record); // 회원가입 체크
            if(isSignUp < 1) {
            	isSignUp = userInfoDao.insertSelective(record); // 회원가입 진행
            }
            
            return email;
            
        } else {
            return null;
        }
	}
}