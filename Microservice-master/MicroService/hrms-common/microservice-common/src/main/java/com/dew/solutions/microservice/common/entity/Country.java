package com.dew.solutions.microservice.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country extends SuperEntity {

	@Column(name = "name")
	private String countryName;

	@Column(name = "code")
	private String countryCode;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(joinColumns = { @JoinColumn(name = "country_id") }, inverseJoinColumns = {
			@JoinColumn(name = "state_id") }, name = "country_state")
	private Set<State> states = new HashSet<>();

}
