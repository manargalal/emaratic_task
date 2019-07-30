package com.emaratech.assignment.exception;

import java.util.Date;
import java.util.Optional;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emaratech.assignment.exception.model.Defect;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PhoneRegisteryExceptionHandler extends ResponseEntityExceptionHandler{


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Defect> handleAllExceptions(Exception ex, WebRequest request) {
	  Defect errorDetails = new Defect(new Date(), ex.getMessage(),
	      request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(NumberNotFoundException.class)
	public ResponseEntity<VndErrors> notFoundException(NumberNotFoundException e) {
		return error(e, HttpStatus.NOT_FOUND, String.valueOf(e.getCode()));
	}

	private <E extends Exception> ResponseEntity<VndErrors> error(
			final E exception, final HttpStatus httpStatus, final String logRef) {
		final String message =
				Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	}




}
