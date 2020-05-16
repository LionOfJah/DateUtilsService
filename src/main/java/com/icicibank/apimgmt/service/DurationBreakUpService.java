package com.icicibank.apimgmt.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.model.ResponseModel;

@Service
public interface DurationBreakUpService {

	public String getBreakUpDurations(DurationDetails duration) throws JsonProcessingException ;
}
