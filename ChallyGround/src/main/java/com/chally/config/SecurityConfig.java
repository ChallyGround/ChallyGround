/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 스프링 세큐리티 설정
***/
package com.chally.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chally.filter.JwtAuthenticationFilter;
import com.chally.user.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtUtil jwtUtil;
	
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
				//.requestMatchers("/" ,"/index.html","/public/**", "/static/**", "/webjars/**").permitAll()
				.anyRequest().authenticated())
				.oauth2Login(oauth2Login -> oauth2Login.defaultSuccessUrl("/axios/login"))
				.csrf(csrf -> csrf.disable())
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.userDetailsService(userDetailsService);

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/chally/chlogin" ,"/" ,"/index.html","/public/**", "/static/**", "/webjars/**");
	}
}