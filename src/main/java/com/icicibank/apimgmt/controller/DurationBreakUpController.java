package com.icicibank.apimgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.model.ResponseModel;
import com.icicibank.apimgmt.service.DurationBreakUpService;

@RestController
public class DurationBreakUpController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DurationBreakUpService durationBreakUpService;
	
	@Autowired
	ResponseModel responseModel;
	
	@RequestMapping(method=RequestMethod.POST,value = "${app.url}",consumes = "application/json")
	public ResponseEntity<ResponseModel> getDurationBreakupDetails(@RequestBody DurationDetails durationDetails) {

		logger.info(durationDetails.toString());
		responseModel=durationBreakUpService.getBreakUpDurations(durationDetails);
		return ResponseEntity.ok().body(responseModel);
	}
}
