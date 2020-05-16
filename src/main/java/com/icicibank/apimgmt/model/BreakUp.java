package com.icicibank.apimgmt.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
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
