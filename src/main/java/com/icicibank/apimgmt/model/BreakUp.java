package com.icicibank.apimgmt.model;

import org.springframework.stereotype.Component;

@Component
public class BreakUp {

	
	private String duration;

	public BreakUp() {
		
	}

	public BreakUp(String duration) {
		
		this.duration = duration;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "BreakUp [duration=" + duration + "]";
	}
	
	
	
	
}
