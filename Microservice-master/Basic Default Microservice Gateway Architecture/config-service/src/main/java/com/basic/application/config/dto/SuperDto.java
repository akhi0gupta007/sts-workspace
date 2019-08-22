package com.basic.application.config.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class SuperDto {

	private Long id;

	private Date createdDate;

	private Date lastModifiedDate;

	private Long modifiedBy;

	private Long createdBy;

	private Boolean isDeleted = false;

}
