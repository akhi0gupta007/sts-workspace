package com.dew.solutions.microservice.config.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkillsDto extends SuperDto {

	private Long employeeId;

	private Set<SkillDto> skills = new HashSet<>();

	private Float selfRating;

	private Float givenRating;


}
