package com.dew.solutions.microservice.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.common.service.ICountryService;
import com.dew.solutions.microservice.config.controller.GenericCrudController;
import com.dew.solutions.microservice.config.dto.CountryDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.util.Utility;

@RestController
@RequestMapping("/country")
public class CountryController extends GenericCrudController<CountryDto, ICountryService> {

	private ICountryService iCountryService;

	@Autowired
	public CountryController(ICountryService iCountryService) {
		super(iCountryService);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdate(@RequestParam String name) {
		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "data",
					iCountryService.findByCountryName(name)));
		} catch (ServiceException e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}
}
