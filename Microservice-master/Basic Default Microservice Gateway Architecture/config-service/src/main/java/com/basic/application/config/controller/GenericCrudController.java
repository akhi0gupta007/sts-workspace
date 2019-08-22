package com.basic.application.config.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.application.config.constants.ApplicationConstants.ParsedRequestData;
import com.basic.application.config.dto.SuperDto;
import com.basic.application.config.service.IGenericService;
import com.basic.application.config.util.Utility;

//TODO Change Super Entity to Super DTO || implementation will always return DTO instead of database objects
public abstract class GenericCrudController<T extends SuperDto, S extends IGenericService<T, Long>> {

	private S service;

	@SuppressWarnings("unused")
	private GenericCrudController() {

	}

	public GenericCrudController(S service) {
		this.service = service;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable Long id) {

		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "data",
					service.get(id, request.getHeader(request.getHeader(ParsedRequestData.HEADER)))));
		} catch (Throwable e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAll(HttpServletRequest request) {

		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "Data",
					service.getAll(request.getHeader(ParsedRequestData.HEADER))));
		} catch (Throwable e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdate(HttpServletRequest request, @RequestBody T entity) {
		try {
			return ResponseEntity.ok().body(Utility.sendSuccessResponse("Data Retrieved Successfully", "data",
					service.saveOrUpdate(entity, request.getHeader(ParsedRequestData.HEADER))));
		} catch (Throwable e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> saveOrUpdate(HttpServletRequest request, @PathVariable long id) {
		try {
			return ResponseEntity.ok()
					.body(Utility.sendSuccessResponse("Data Retrieved Successfully", "deleted",
							service.remove(service.get(id, request.getHeader(ParsedRequestData.HEADER)),
									request.getHeader(ParsedRequestData.HEADER))));
		} catch (Throwable e) {
			return ResponseEntity.ok().body(Utility.sendFailureResponse(e));
		}
	}

}
