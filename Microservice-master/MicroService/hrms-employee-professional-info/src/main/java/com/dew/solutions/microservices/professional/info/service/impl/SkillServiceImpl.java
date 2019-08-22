package com.dew.solutions.microservices.professional.info.service.impl;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.config.dto.SkillDto;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;
import com.dew.solutions.microservices.professional.info.entity.Skill;
import com.dew.solutions.microservices.professional.info.repository.ISkillRepository;
import com.dew.solutions.microservices.professional.info.service.ISkillService;

@Service
@Transactional(rollbackFor=Throwable.class)
public class SkillServiceImpl extends AbstractGenericServiceImpl<SkillDto, Long> implements ISkillService {

	private ISkillRepository iSkillRepository;

	private Mapper mapper;

	public SkillServiceImpl(ISkillRepository iSkillRepository, Mapper mapper) {
		super(iSkillRepository, mapper, Skill.class, SkillDto.class);
		this.iSkillRepository = iSkillRepository;
		this.mapper = mapper;
	}

	public SkillDto findBySkillName(String skillName) {
		return this.mapper.map(iSkillRepository.findBySkillName(skillName), SkillDto.class);
	}

}
