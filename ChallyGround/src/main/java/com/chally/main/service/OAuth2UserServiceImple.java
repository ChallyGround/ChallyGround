/***
 *최초 작성자: OOO
 *최초 작성일: 2000.00.00 (월)
 *목적: 로그인관련 DAO
***/
package com.chally.main.service;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import org.springframework.stereotype.Service;

@Service
public class OAuth2UserServiceImple implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User =  new DefaultOAuth2UserService().loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth2 제공 업체에 따라 사용자 정보 처리
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> userAttributes = Map.of(
        	"sub", attributes.get("sub"),
            "name", attributes.get("name"),
            "email", attributes.get("email")
        );

        return new DefaultOAuth2User(
            oAuth2User.getAuthorities(),
            userAttributes,
            "sub"
        );
    }
}
