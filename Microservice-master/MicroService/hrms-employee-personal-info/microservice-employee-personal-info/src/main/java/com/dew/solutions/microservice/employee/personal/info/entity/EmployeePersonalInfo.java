package com.dew.solutions.microservice.employee.personal.info.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.dew.solutions.microservice.config.entity.SuperEntity;
import com.dew.solutions.microservice.config.enums.Gender;
import com.dew.solutions.microservice.config.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeePersonalInfo extends SuperEntity {

	@JsonProperty()
	private String firstName;

	@JsonProperty
	private String middleName;

	@JsonProperty
	private String lastName;

	@JsonProperty
	private String displayName;

	@JsonProperty
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonProperty
	private Date dateOfBirth;

	@JsonProperty
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	@JsonProperty
	private Long nationalityId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false, unique = false)
	private Set<Address> address = new HashSet<>();

	@JsonProperty
	private String homeTelePhone;

	@JsonProperty
	private String mobile;

	@JsonProperty
	private String workTelephone;

	@JsonProperty
	private String workEmail;

	@JsonProperty
	private String otherEmail;

	@JsonProperty
	private Date joiningDate;

	@JsonProperty
	private Long designationId;

	@JsonProperty
	private Long managerId;

	@JsonProperty
	@Column(length = 1000)
	private String comments;

}
