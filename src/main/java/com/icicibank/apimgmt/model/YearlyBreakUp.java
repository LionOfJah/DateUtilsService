package com.icicibank.apimgmt.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,value = "prototype")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class YearlyBreakUp {

	private int noOfYearlyBreakUps;

	private List<BreakUp> listOfDurations;

	public YearlyBreakUp() {
		
	}

	public YearlyBreakUp(int noOfYearlyBreakUps, List<BreakUp> listOfDurations) {

		this.noOfYearlyBreakUps = noOfYearlyBreakUps;
		this.listOfDurations = listOfDurations;
	}

	public int getNoOfYearlyBreakUps() {
		return noOfYearlyBreakUps;
	}

	public void setNoOfYearlyBreakUps(int noOfYearlyBreakUps) {
		this.noOfYearlyBreakUps = noOfYearlyBreakUps;
	}

	public List<BreakUp> getListOfDurations() {
		return listOfDurations;
	}

	public void setListOfDurations(List<BreakUp> listOfDurations) {
		this.listOfDurations = listOfDurations;
	}

	@Override
	public String toString() {
		return "YearlyBreakUp [noOfYearlyBreakUps=" + noOfYearlyBreakUps + ", listOfDurations=" + listOfDurations + "]";
	}

	
}
