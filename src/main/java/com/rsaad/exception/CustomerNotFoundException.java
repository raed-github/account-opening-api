package com.rsaad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rsaad.constants.CustomerConstants;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException() {
		super(CustomerConstants.CUSTOMER_DOES_NOT_EXIST);
	}
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
