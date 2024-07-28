// JwtAuthenticationFilter.java

package com.chally.filter;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.chally.config.JwtUtil;
import com.chally.user.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;
    private UserDetailsServiceImpl userDetailsService;

    
    @Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        // 인증이 필요 없는 URL 패턴을 설정
        if (requestURI.startsWith("/api/auth/register") || requestURI.startsWith("/api/login")) {
            chain.doFilter(request, response);  // 필터를 적용하지 않고 체인 계속 진행
            return;
        }
        
        final String authorizationHeader = request.getHeader("Authorization");
        
        String email = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Chally ")) {
            jwt = authorizationHeader.substring(7);
            try {
            	email = jwtUtil.extractKey(jwt);
            } catch (ExpiredJwtException | MalformedJwtException | SignatureException e) {
            	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 401 상태 코드 설정
                return; 
            }
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtUtil.validateToken(jwt, email)) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);  // 사용자 객체 로드
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 401 상태 코드 설정
            return;  // 필터 체인 중단
        }
        
        chain.doFilter(request, response);
    }
}
