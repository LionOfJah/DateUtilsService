package com.icicibank.apimgmt.exceptions.handler;

import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.icicibank.apimgmt.exceptions.InvalidDatePeriod;
import com.icicibank.apimgmt.model.ResponseModel;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@Autowired
	ResponseModel responseModel;
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ResponseModel> dateFormatExceptionHandler(Exception ex,WebRequest request){
		responseModel.setStatus("fail");
		responseModel.getErrorResponse().setErrorCode("E-101");
		responseModel.getErrorResponse().setErrorMessage("date format is incorrect,expected format is dd-MM-yyyy");
		
		
		return ResponseEntity.ok().header("content-type", "application/xml").body(responseModel);
	}
	
	@ExceptionHandler(InvalidDatePeriod.class)
	public ResponseEntity<ResponseModel> invalidDateExceptionHandler(Exception ex,WebRequest request){
		
		responseModel.setStatus("fail");
		responseModel.getErrorResponse().setErrorCode("E-102");
		responseModel.getErrorResponse().setErrorMessage("startDate should be less than endDate");
		
		
		return ResponseEntity.ok().header("content-type", "application/xml").body(responseModel);
	}
}
