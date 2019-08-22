package com.dew.solutions.microservice.config.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto extends SuperDto {

	private String countryName;

	private String countryCode;

	private Set<StateDto> states = new HashSet<>();

}
