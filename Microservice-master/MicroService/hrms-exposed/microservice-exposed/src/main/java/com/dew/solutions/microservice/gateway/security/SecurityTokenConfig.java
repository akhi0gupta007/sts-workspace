package com.dew.solutions.microservice.gateway.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dew.solutions.microservice.config.constants.JwtConfig;
import com.dew.solutions.microservice.gateway.component.SimpleCORSFilter;

@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtConfig jwtConfig;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, jwtConfig.getUri(), jwtConfig.getMicroserviceCreateAuthenticationUri())
				.permitAll().antMatchers("**/*").authenticated().and().anonymous();
		http.addFilterBefore(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class);
		http.addFilter(new SimpleCORSFilter());
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, jwtConfig.getUri()).and().ignoring().antMatchers(HttpMethod.POST,
				jwtConfig.getMicroserviceCreateAuthenticationUri());
	}
}