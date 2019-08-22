package com.dew.solutions.microservice.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NationalityDto extends SuperDto {

	private String nationalityName;

	private String nationCode;

}
