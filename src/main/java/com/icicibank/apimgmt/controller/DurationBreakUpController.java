package com.icicibank.apimgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.model.ResponseModel;
import com.icicibank.apimgmt.service.DurationBreakUpService;
import com.icicibank.apimgmt.service.impl.DurationBreakUpServiceImpl;

@RestController
public class DurationBreakUpController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DurationBreakUpService durationBreakUpService;
		
	String responseModel;
	
	@RequestMapping(method=RequestMethod.POST,value = "${app.url}",consumes = "application/json",produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getDurationBreakupDetails(@RequestBody DurationDetails durationDetails) {

	
		
		logger.info(durationDetails.toString());
		
		
		logger.info("durationBreakUpService instance "+durationBreakUpService.hashCode());
		
		logger.info("durationBreakUpService toString"+durationBreakUpService.toString());
		
			
			 try {
				responseModel=durationBreakUpService.getBreakUpDurations(durationDetails);
			} catch (JsonProcessingException e) {
				logger.info(e.getMessage());
			}
			
		
			
			
		return ResponseEntity.ok().body(responseModel);
	}
}
