package com.dew.solutions.microservice.employee.personal.info.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dew.solutions.microservice.config.entity.SuperEntity;
import com.dew.solutions.microservice.config.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends SuperEntity {

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

	@Enumerated(EnumType.STRING)
	private AddressType addressType;

}
