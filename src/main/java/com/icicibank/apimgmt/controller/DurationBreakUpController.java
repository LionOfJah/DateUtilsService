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
	
	String response;
	@RequestMapping(method=RequestMethod.POST,value = "${app.url}",consumes = "application/json",produces = "application/xml")
	@ResponseBody
	public ResponseEntity<ResponseModel> getDurationBreakupDetails(@RequestBody DurationDetails durationDetails) {

	
		
		logger.info(durationDetails.toString());
		
		
		//logger.info("durationBreakUpService instance "+durationBreakUpService.hashCode());
		
		//logger.info("durationBreakUpService toString"+durationBreakUpService.toString());
		
			
			 try {
				response=durationBreakUpService.getBreakUpDurations(durationDetails);
			} catch (JsonProcessingException e) {
				logger.info(e.getMessage());
			}
			if(response!=null || !response.isEmpty()) {
				responseModel.setStatus("success");
				responseModel.setBreakUpDurations(response);
			}else {
				responseModel.setStatus("false");
				responseModel.setBreakUpDurations(response);
			}
		
			
			
		return ResponseEntity.ok().body(responseModel);
	}
}
