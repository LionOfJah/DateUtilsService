package com.icicibank.apimgmt.service;

import org.springframework.stereotype.Service;

import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.model.ResponseModel;

@Service
public interface DurationBreakUpService {

	public ResponseModel getBreakUpDurations(DurationDetails duration);
}
