package com.icicibank.apimgmt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseModel {

	@Autowired
	private YearlyBreakUp yearlyBreakupDetails;
	
	@Autowired
	private QuarterlyBreakUp quarterlyBreakupDetails;
	
	@Autowired
	private MonthlyBreakUp monthlyBreakUpDetails;

	public ResponseModel() {
		
	}

	public ResponseModel(YearlyBreakUp yearlyBreakupDetails, QuarterlyBreakUp quarterlyBreakupDetails,
			MonthlyBreakUp monthlyBreakUpDetails) {
		
		this.yearlyBreakupDetails = yearlyBreakupDetails;
		this.quarterlyBreakupDetails = quarterlyBreakupDetails;
		this.monthlyBreakUpDetails = monthlyBreakUpDetails;
	}

	public YearlyBreakUp getYearlyBreakupDetails() {
		return yearlyBreakupDetails;
	}

	public void setYearlyBreakupDetails(YearlyBreakUp yearlyBreakupDetails) {
		this.yearlyBreakupDetails = yearlyBreakupDetails;
	}

	public QuarterlyBreakUp getQuarterlyBreakupDetails() {
		return quarterlyBreakupDetails;
	}

	public void setQuarterlyBreakupDetails(QuarterlyBreakUp quarterlyBreakupDetails) {
		this.quarterlyBreakupDetails = quarterlyBreakupDetails;
	}

	public MonthlyBreakUp getMonthlyBreakUpDetails() {
		return monthlyBreakUpDetails;
	}

	public void setMonthlyBreakUpDetails(MonthlyBreakUp monthlyBreakUpDetails) {
		this.monthlyBreakUpDetails = monthlyBreakUpDetails;
	}

	@Override
	public String toString() {
		return "ResponseModel [yearlyBreakupDetails=" + yearlyBreakupDetails + ", quarterlyBreakupDetails="
				+ quarterlyBreakupDetails + ", monthlyBreakUpDetails=" + monthlyBreakUpDetails + "]";
	}

	
}
