package com.emaratech.assignment.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;


@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private HttpStatus code;
	
	public NumberNotFoundException(Long id) {
		super("Could not find Number " + id);
	}
	public NumberNotFoundException(String message) {
		super(message);
	}

	public NumberNotFoundException(HttpStatus code, String message) {
		super(message);
		this.code = code;
	}

	public NumberNotFoundException(HttpStatus code, String message, Throwable cause) {
		super(message, cause);		
		this.code = code;
	}

	public NumberNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public NumberNotFoundException(Throwable cause) {
		super(cause);
	}


}
