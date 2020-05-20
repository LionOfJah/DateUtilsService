package com.icicibank.apimgmt.service;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icicibank.apimgmt.exceptions.InvalidDatePeriod;
import com.icicibank.apimgmt.model.DurationDetails;

@Service
@RequestScope
public interface DurationBreakUpService {

	public String getBreakUpDurations(DurationDetails duration) throws JsonProcessingException,InvalidDatePeriod ;
}
