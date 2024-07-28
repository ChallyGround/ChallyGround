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
        // 데이터베이스에서 사용자 정보를 로드
        // 예시로 이메일로 사용자 정보를 조회하고, UserDetails를 반환합니다.
        // 실제로는 UserRepository 등을 사용하여 사용자 정보를 로드합니다.
        UserInfo user = userDao.findByEmail(email);  // 사용자 조회 로직
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user.getEmail(), null, new ArrayList<>(), user.getName());
    }
}

