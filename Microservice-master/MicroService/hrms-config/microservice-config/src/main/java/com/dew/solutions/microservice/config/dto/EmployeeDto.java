package com.dew.solutions.microservice.config.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;

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
public class EmployeeDto extends SuperDto {

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

	private Set<AddressDto> address = new HashSet<>();

	@JsonProperty("marritalStatus")
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

	private EmployeeSkillsDto employeeSkillsDto;

	public void mapEmployeeSkills(ResponseEntity<?> response) {
		this.employeeSkillsDto = ((EmployeeSkillsDto) response.getBody());
	}
}
