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
public class QuarterlyBreakUp {

	private int noOfQuaterlyBreakUps;
	
	private List<BreakUp> listOfDurations;

	public QuarterlyBreakUp() {
		
	}

	public QuarterlyBreakUp(int noOfQuaterlyBreakUps, List<BreakUp> listOfDurations) {
		super();
		this.noOfQuaterlyBreakUps = noOfQuaterlyBreakUps;
		this.listOfDurations = listOfDurations;
	}

	public int getNoOfQuaterlyBreakUps() {
		return noOfQuaterlyBreakUps;
	}

	public void setNoOfQuaterlyBreakUps(int noOfQuaterlyBreakUps) {
		this.noOfQuaterlyBreakUps = noOfQuaterlyBreakUps;
	}

	public List<BreakUp> getListOfDurations() {
		return listOfDurations;
	}

	public void setListOfDurations(List<BreakUp> listOfDurations) {
		this.listOfDurations = listOfDurations;
	}

	@Override
	public String toString() {
		return "QuarterlyBreakUp [noOfQuaterlyBreakUps=" + noOfQuaterlyBreakUps + ", listOfDurations=" + listOfDurations
				+ "]";
	}

	
}
