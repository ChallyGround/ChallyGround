/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 스프링 세큐리티 설정
***/
package com.chally.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
        )
        .oauth2Login(oauth2Login ->
            oauth2Login.defaultSuccessUrl("/api/login") // , true // 
        )
        .csrf(csrf -> csrf.disable());
//        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // 추후 jwt 사용

        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**");
    }

/*	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
	    return new JwtAuthenticationFilter();
	}*/
}