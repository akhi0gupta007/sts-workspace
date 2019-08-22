package com.dew.solutions.microservice.config.dto;

import java.util.Date;
import java.util.Set;

import com.dew.solutions.microservice.config.enums.Gender;
import com.dew.solutions.microservice.config.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePersonalInfoDto extends SuperDto {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("middleName")
	private String middleName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("displayName")
	private String displayName;

	@JsonProperty("gender")
	private Gender gender;

	@JsonProperty("dateOfBirth")
	private Date dateOfBirth;

	private Set<AddressDto> address;

	@JsonProperty("maritalStatus")
	private MaritalStatus maritalStatus;

	@JsonProperty("nationalityId")
	private Long nationalityId;

	@JsonProperty("homeTelePhone")
	private String homeTelePhone;

	private String mobile;

	private String workTelephone;

	private String workEmail;

	private String otherEmail;

	private Date joiningDate;

	@JsonProperty
	private Long designationId;

	private Long managerId;

	private String comments;
}
