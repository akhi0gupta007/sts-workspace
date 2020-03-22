package org.akhi.spring.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> resourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		String body = "Above resource is not found";
		//return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request); //Plain error handling
		
		//custom way for handling exception
		CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<CustomErrorResponse>(errors,HttpStatus.NOT_FOUND);

	}

}
