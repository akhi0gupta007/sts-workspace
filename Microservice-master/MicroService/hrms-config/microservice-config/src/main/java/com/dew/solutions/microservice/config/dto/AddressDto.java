package com.dew.solutions.microservice.config.dto;

import com.dew.solutions.microservice.config.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto extends SuperDto{
	
	@JsonProperty("addressLine1")
	private String addressLine1;
	
	@JsonProperty("addressLine2")
	private String addressLine2;
	
	@JsonProperty("addressLine3")
	private String addressLine3;
	
	@JsonProperty("city")
	private Long city;
	
	@JsonProperty("state")
	private Long state;
	
	@JsonProperty("pincode")
	private String pincode;
	
	@JsonProperty("country")
	private Long country;
	
	@JsonProperty("addressType")
	private AddressType addressType;
		
}
