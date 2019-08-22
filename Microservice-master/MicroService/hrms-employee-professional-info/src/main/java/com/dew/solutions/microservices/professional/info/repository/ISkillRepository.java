package com.dew.solutions.microservices.professional.info.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.config.repository.IGenericRepository;
import com.dew.solutions.microservices.professional.info.entity.Skill;

@Repository
public interface ISkillRepository extends IGenericRepository<Skill, Long> {

	public Skill findBySkillName(String skillName);
}
