package com.jdc.mailing.utils.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Value("${app.token.prefix}")
	private String tokenPrefix;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var authHeader = request.getHeader("Authorization");
		
		if(StringUtils.hasLength(authHeader) && authHeader.startsWith(tokenPrefix)) {
			var token = authHeader.substring(tokenPrefix.length());
			var authentication = tokenProvider.parseAccess(token);
			
			if(null != authentication) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
			
		filterChain.doFilter(request, response);
	}

}
