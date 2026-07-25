package com.sunny.code_assistant.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetail> handleAllException(Exception ex, WebRequest request) throws Exception{
		ErrorDetail errorDetails = new ErrorDetail(request.getDescription(false),ex.getMessage(),LocalDate.now());
		return new ResponseEntity<ErrorDetail>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
