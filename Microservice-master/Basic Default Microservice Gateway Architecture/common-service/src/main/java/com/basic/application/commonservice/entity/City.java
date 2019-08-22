package com.basic.application.commonservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.basic.application.config.entity.SuperEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends SuperEntity {

	@Column(name = "name")
	private String cityName;

}
