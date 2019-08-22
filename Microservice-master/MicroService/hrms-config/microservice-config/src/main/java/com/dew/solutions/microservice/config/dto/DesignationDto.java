package com.dew.solutions.microservice.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignationDto extends SuperDto {

	private String designationName;

	private String designationCode;

}
