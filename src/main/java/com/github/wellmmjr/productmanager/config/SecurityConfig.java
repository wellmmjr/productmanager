package com.github.wellmmjr.productmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.wellmmjr.productmanager.security.jwt.security.jwt.JwtConfigurer;
import com.github.wellmmjr.productmanager.security.jwt.security.jwt.JwtTokenProvider;


@Configuration
public class SecurityConfig {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
		}
	
	@Bean
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().disable().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeHttpRequests(request -> request
				.requestMatchers("/auth/signin", "/api-docs/**", "swagger-ui.html").permitAll()
				.requestMatchers("/api/**").authenticated()
				.requestMatchers("/users").denyAll()
				.and().apply(new JwtConfigurer(jwtTokenProvider))
			);
		
	}
	
}
