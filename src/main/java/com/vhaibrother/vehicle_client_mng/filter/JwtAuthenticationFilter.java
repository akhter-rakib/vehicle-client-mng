package com.vhaibrother.vehicle_client_mng.filter;


import com.vhaibrother.vehicle_client_mng.entity.User;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.UserRepository;
import com.vhaibrother.vehicle_client_mng.service.impl.CustomUserDetailsService;
import com.vhaibrother.vehicle_client_mng.util.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(UserRepository userRepository, JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String username = null;
            String jwt = null;
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            try {
                UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
                if (StringUtils.hasText(jwt) && jwtUtil.validateToken(jwt, userDetails)) {
                    String userId = jwtUtil.extractUsername(jwt);
                    User user = userRepository.getByUserNameAndActiveStatusTrue(ActiveStatus.ACTIVE.getValue(), userId);
                    // UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getUserName());
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {

            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
