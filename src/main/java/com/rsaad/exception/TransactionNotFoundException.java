package com.rsaad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rsaad.constants.TransactionConstants;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends RuntimeException{
	
	public TransactionNotFoundException() {
		super(TransactionConstants.TRANSACTION_DOES_NOT_EXIST);
	}
	
	public TransactionNotFoundException(String msg) {
		super(msg);		
	}
}
