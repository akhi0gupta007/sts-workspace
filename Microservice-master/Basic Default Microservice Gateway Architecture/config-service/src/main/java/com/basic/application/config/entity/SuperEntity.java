package com.basic.application.config.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class SuperEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Getter
	@Setter
	private Date createdDate;

	@Getter
	@Setter
	private Date lastModifiedDate;

	@Getter
	@Setter
	private Long modifiedBy;

	@Getter
	@Setter
	private Long createdBy;

	@Getter
	@Setter
	private Boolean isDeleted = false;

	@PrePersist
	protected void onCreate() {
		this.createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastModifiedDate = new Date();
	}

}
