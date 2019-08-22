package com.dew.solutions.microservices.professional.info.entity;

import java.util.Set;

import javax.persistence.Entity;

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
public class Category extends SuperEntity {

	private String categoryName;

}
