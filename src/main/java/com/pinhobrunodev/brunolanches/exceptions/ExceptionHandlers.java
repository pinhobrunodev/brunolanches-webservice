package com.pinhobrunodev.brunolanches.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanBusiness;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanNotFound;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserBusiness;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserNotFound;

@ControllerAdvice
public class ExceptionHandlers extends  ResponseEntityExceptionHandler {

	@ExceptionHandler(ExceptionUserBusiness.class)
	protected ResponseEntity<ExceptionResponse> userAlreadyExistsExceptionHandlers(ExceptionUserBusiness e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(ExceptionUserNotFound.class)
	protected  ResponseEntity<ExceptionResponse> userNotFoundExceptionHandler(ExceptionUserNotFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(ExceptionDeliverymanBusiness.class)
	protected ResponseEntity<ExceptionResponse> deliverymanAlreadyExistsExceptionBusiness(ExceptionDeliverymanBusiness e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(ExceptionDeliverymanNotFound.class)
	protected ResponseEntity<ExceptionResponse> deliverymanNotFoundExceptionHandler(ExceptionDeliverymanNotFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
}
