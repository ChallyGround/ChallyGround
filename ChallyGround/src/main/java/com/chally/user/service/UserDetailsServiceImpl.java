/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.27
 *목적: JWT 발급시 사용자 정보 전달
***/
package com.chally.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chally.dao.UserInfoMapper;
import com.chally.user.CustomUserDetails;
import com.chally.vo.UserInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserInfoMapper userDao;
	
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo user = userDao.findByEmail(email);  // 사용자 조회 쿼리
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user.getEmail(), null, new ArrayList<>(), user.getName(),user.getTel(), user.getOauthId(), user.getId(), user.getBirth());
    }
}

