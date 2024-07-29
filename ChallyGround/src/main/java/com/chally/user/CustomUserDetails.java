package com.chally.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String email; //이메일
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String name;  // 닉네임
    private String tel; // 전화번호
    //private Date birth; //데이터타입 확인 필요
    private String oauthId; // 구글(sub)
    private int id; // PK값

    // Constructor
    public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities,
                             String name,String tel ,String oauthId, int id) {
        this.email = email; // 이메일
        this.password = password;
        this.authorities = authorities;
        this.name = name;
        this.tel = tel;
        this.oauthId = oauthId;
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getter for additional fields
    public String getName() {
        return name;
    }
    
    public String getOauthId() {
    	return oauthId;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getTel() {
    	return tel;
    }
}
