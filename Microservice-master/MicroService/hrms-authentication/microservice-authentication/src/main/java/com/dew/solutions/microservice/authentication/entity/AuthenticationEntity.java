package com.dew.solutions.microservice.authentication.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class AuthenticationEntity extends SuperEntity {

	public AuthenticationEntity(Long id, String username, String password, String roleName) {
		this.setId(id);
		this.username = username;
		this.password = password;
		this.roles.add(new Role(roleName));
	}

	public AuthenticationEntity(String username, String password, List<GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		authorities.forEach(authority -> {
			this.roles.add(new Role(authority.getAuthority()));
		});
	}

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "authentication_role", joinColumns = {
			@JoinColumn(name = "authetication_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

}
