package com.icicibank.apimgmt.exceptions.handler;

import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.icicibank.apimgmt.exceptions.InvalidDatePeriod;
import com.icicibank.apimgmt.model.ErrorResponseModel;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@Autowired
	ErrorResponseModel errorresponse;
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ErrorResponseModel> dateFormatExceptionHandler(Exception ex,WebRequest request){
		
		errorresponse.setErrorCode("E-101");
		errorresponse.setErrorMessage("date format is incorrect,expected format is dd-MM-yyyy");
		errorresponse.setStatus("fail");
		
		return ResponseEntity.ok().header("content-type", "application/xml").body(errorresponse);
	}
	
	@ExceptionHandler(InvalidDatePeriod.class)
	public ResponseEntity<ErrorResponseModel> invalidDateExceptionHandler(Exception ex,WebRequest request){
		
		errorresponse.setErrorCode("E-102");
		errorresponse.setErrorMessage("startDate should be less than endDate");
		errorresponse.setStatus("fail");
		
		return ResponseEntity.ok().header("content-type", "application/xml").body(errorresponse);
	}
}
