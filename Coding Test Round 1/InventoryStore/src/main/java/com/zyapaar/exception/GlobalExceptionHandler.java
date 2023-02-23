package com.zyapaar.exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InventoryException.class)
	public ResponseEntity<ErrorTemp> driverExceptionHandler(InventoryException ex, WebRequest req){
		
		ErrorTemp myErr = new ErrorTemp();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemp>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorTemp> notFoundExceptionHandler(NotFoundException ex, WebRequest req){
		
		ErrorTemp myErr = new ErrorTemp();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemp>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	
//	Exception Which are not handled will be handle by Parent exceptionHandler..
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorTemp> exceptionHandler(Exception ex, WebRequest req){
		
		ErrorTemp myErr = new ErrorTemp();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemp>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
