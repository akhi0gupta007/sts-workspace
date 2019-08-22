package com.basic.application.commonservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.application.commonservice.service.ICityService;
import com.basic.application.config.controller.GenericCrudController;
import com.basic.application.config.dto.CityDto;
import com.basic.application.config.util.Utility;

@RestController
@RequestMapping("/city")
public class CityController extends GenericCrudController<CityDto, ICityService> {

	private ICityService iCityService;

	@Autowired
	public CityController(ICityService iCityService) {
		super(iCityService);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdate(@RequestParam String name) {
		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "data",
					iCityService.findByCityName(name)));
		} catch (Exception e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}
}
