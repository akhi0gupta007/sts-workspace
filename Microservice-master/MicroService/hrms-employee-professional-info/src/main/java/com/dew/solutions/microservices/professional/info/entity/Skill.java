package com.dew.solutions.microservices.professional.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Skill extends SuperEntity {

	@Column(nullable = false, unique = true)
	private String skillName;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(length = 1000)
	private String tags;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
