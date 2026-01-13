package com.jdc.mailing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import com.jdc.mailing.utils.exceptions.handlers.SecurityExceptionResolver;
import com.jdc.mailing.utils.security.JwtTokenFilter;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		http.csrf(csrf -> csrf.disable());
		http.cors(_-> {});
		http.sessionManagement(
			session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		);
		
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/management/**").hasAuthority("Admin")
				.requestMatchers("/member/**").hasAuthority("Member")
				.anyRequest().authenticated()
			);
		
		http.exceptionHandling(
			exceptions -> exceptions
				.authenticationEntryPoint(securityExceptionResolver())
				.accessDeniedHandler(securityExceptionResolver())
		);
		
		http.addFilterBefore(jwtTokenFilter(), AuthorizationFilter.class);
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
		return config.getAuthenticationManager();
	}
	
	@Bean
	SecurityExceptionResolver securityExceptionResolver() {
		return new SecurityExceptionResolver();
	}
	
	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
}
