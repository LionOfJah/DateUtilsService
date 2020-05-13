package com.icicibank.apimgmt.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MonthlyBreakUp {

	private int noOfMonthlyBreakUp;

	private List<BreakUp> listOfDurations;

	public MonthlyBreakUp() {

	}

	public MonthlyBreakUp(int noOfMonthlyBreakUp, List<BreakUp> listOfDurations) {
		super();
		this.noOfMonthlyBreakUp = noOfMonthlyBreakUp;
		this.listOfDurations = listOfDurations;
	}

	public int getNoOfMonthlyBreakUp() {
		return noOfMonthlyBreakUp;
	}

	public void setNoOfMonthlyBreakUp(int noOfMonthlyBreakUp) {
		this.noOfMonthlyBreakUp = noOfMonthlyBreakUp;
	}

	public List<BreakUp> getListOfDurations() {
		return listOfDurations;
	}

	public void setListOfDurations(List<BreakUp> listOfDurations) {
		this.listOfDurations = listOfDurations;
	}

	@Override
	public String toString() {
		return "MonthlyBreakUp [noOfMonthlyBreakUp=" + noOfMonthlyBreakUp + ", listOfDurations=" + listOfDurations
				+ "]";
	}

	
}
