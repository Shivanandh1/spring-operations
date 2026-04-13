package com.hoangtien2k3.orderservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class JwtTokenFilter {

    private JwtTokenFilter() {
    }

    /**
     * Extract JWT token from the request Authorization header or SecurityContext
     * 
     * @return JWT token with "Bearer " prefix
     */
    public static String getTokenFromRequest() {
        // First, try to get token from SecurityContext (most reliable)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication instanceof JwtAuthenticationToken jwtToken) {
            Jwt jwt = jwtToken.getToken();
            return "Bearer " + jwt.getTokenValue();
        }

        // Fallback: try to get from HTTP request headers
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                return authHeader;
            }
        }

        return null;
    }
}
