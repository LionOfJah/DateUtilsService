package com.icicibank.apimgmt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
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
