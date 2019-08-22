package com.dew.solutions.microservice.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.common.service.IStateService;
import com.dew.solutions.microservice.config.controller.GenericCrudController;
import com.dew.solutions.microservice.config.dto.StateDto;

@RestController
@RequestMapping("/state")
public class StateController extends GenericCrudController<StateDto, IStateService> {

	private IStateService iStateService;

	@Autowired
	public StateController(IStateService iStateService) {
		super(iStateService);
		this.iStateService = iStateService;
	}

}
