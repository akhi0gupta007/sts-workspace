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
public class State extends SuperEntity {

	@Column(name = "name")
	private String stateName;

	@Column(name = "code")
	private String stateCode;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(joinColumns = { @JoinColumn(name = "state_id") }, inverseJoinColumns = {
			@JoinColumn(name = "city_id") }, name = "state_city")
	private Set<City> cities = new HashSet<>();
}
