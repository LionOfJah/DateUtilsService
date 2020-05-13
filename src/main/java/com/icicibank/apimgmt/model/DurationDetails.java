package com.icicibank.apimgmt.model;

import org.springframework.stereotype.Component;

@Component
public class DurationDetails {
	
	private String startDate;
	
	private String endDate;

	public DurationDetails() {
		
	}

	public DurationDetails(String startDate, String endDate) {
		
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DurationDetails [startDate=" + startDate + ", endDate=" + endDate + "]";
	}



}
