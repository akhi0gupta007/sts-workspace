package com.dew.solutions.microservices.professional.info.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkills extends SuperEntity {

	@Column(unique = true, nullable = false)
	private Long employeeId;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = { @JoinColumn(name = "employeeSkillId") }, inverseJoinColumns = {
			@JoinColumn(name = "skillId") })
	private Set<Skill> skills = new HashSet<>();

	private Float selfRating;

	private Float givenRating;
}
