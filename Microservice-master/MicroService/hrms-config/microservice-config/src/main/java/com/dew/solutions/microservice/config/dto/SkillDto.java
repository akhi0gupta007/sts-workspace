package com.dew.solutions.microservice.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto extends SuperDto {

	private String name;

	private String code;

	private String tags;

	private CategoryDto category;

}
