package com.pinhobrunodev.brunolanches.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanBusiness;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanNotFound;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderEmptyList;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderNotFound;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderStatus;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionEmptyUserList;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserBusiness;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserNotFound;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ExceptionUserBusiness.class)
	protected ResponseEntity<ExceptionResponse> userAlreadyExistsExceptionHandlers(ExceptionUserBusiness e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(ExceptionUserNotFound.class)
	protected ResponseEntity<ExceptionResponse> userNotFoundExceptionHandler(ExceptionUserNotFound e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(ExceptionEmptyUserList.class)
	protected ResponseEntity<ExceptionResponse> emptyUserListExceptionHandler(ExceptionEmptyUserList e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(ExceptionDeliverymanBusiness.class)
	protected ResponseEntity<ExceptionResponse> deliverymanAlreadyExistsExceptionBusiness(
			ExceptionDeliverymanBusiness e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(ExceptionDeliverymanNotFound.class)
	protected ResponseEntity<ExceptionResponse> deliverymanNotFoundExceptionHandler(ExceptionDeliverymanNotFound e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(ExceptionOrderNotFound.class)
	protected ResponseEntity<ExceptionResponse> orderNotFoundExceptionHandler(ExceptionOrderNotFound e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(ExceptionOrderEmptyList.class)
	protected ResponseEntity<ExceptionResponse> orderListEmptyExceptionHandler(ExceptionOrderEmptyList e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(ExceptionOrderStatus.class)
	protected ResponseEntity<ExceptionResponse> orderStatusExceptionResponse (ExceptionOrderStatus e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
}
