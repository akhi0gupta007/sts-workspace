package com.dew.solutions.microservice.authentication.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.authentication.entity.AuthenticationEntity;
import com.dew.solutions.microservice.authentication.repository.IAuthenticationRepository;

@Service
@Transactional(rollbackFor = Throwable.class)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IAuthenticationRepository iAuthenticationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AuthenticationEntity user = iAuthenticationRepository.findByUsername(username);

		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + user.getRoles());

			return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}