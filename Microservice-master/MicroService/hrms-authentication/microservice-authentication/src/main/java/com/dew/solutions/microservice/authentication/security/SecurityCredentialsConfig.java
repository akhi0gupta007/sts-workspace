package com.dew.solutions.microservice.authentication.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dew.solutions.microservice.config.constants.JwtConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;

	@Autowired
	private ObjectMapper objectMapper;

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.csrf().disable().sessionManagement().sessionCreationPolicy(
		 * SessionCreationPolicy.STATELESS).and() .exceptionHandling()
		 * .authenticationEntryPoint((req, rsp, e) ->
		 * rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
		 * .authorizeRequests() .antMatchers(HttpMethod.POST,
		 * jwtConfig.getMicroserviceLoginUri(), "/createAuthentication").permitAll()
		 * .antMatchers("**").authenticated().and().anonymous(); http.addFilter( new
		 * JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(),
		 * jwtConfig, objectMapper));
		 * 
		 */

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig,
						objectMapper))
				.authorizeRequests().antMatchers(HttpMethod.POST, jwtConfig.getMicroserviceLoginUri()).permitAll()
				.antMatchers(HttpMethod.POST, jwtConfig.getMicroserviceCreateAuthenticationUri()).permitAll()
				.antMatchers("**/*").authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}