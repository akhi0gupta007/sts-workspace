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
public class StateDto extends SuperDto {

	private String stateName;

	private String stateCode;

	private Set<CityDto> cities = new HashSet<>();

}
