package com.dew.solutions.microservice.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.common.entity.Designation;
import com.dew.solutions.microservice.common.service.IDesignationService;
import com.dew.solutions.microservice.config.controller.GenericCrudController;
import com.dew.solutions.microservice.config.dto.DesignationDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.util.Utility;

@RestController(value = "/Designation")
public class DesignationController extends GenericCrudController<DesignationDto, IDesignationService> {

	private IDesignationService iDesignationService;

	@Autowired
	public DesignationController(IDesignationService iDesignationService) {
		super(iDesignationService);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdate(@RequestParam String name) {
		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "data",
					iDesignationService.findByDesignationName(name)));
		} catch (ServiceException e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}
}
