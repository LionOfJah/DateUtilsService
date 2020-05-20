package com.icicibank.apimgmt.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@XmlRootElement
public class SuccessResponseModel {
	
	
	private String status;
	
	
	private String breakUpDurations;

	public SuccessResponseModel() {
		
	}

	public SuccessResponseModel(String status, String breakUpDurations) {
		
		this.status = status;
		this.breakUpDurations = breakUpDurations;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBreakUpDurations() {
		return breakUpDurations;
	}

	public void setBreakUpDurations(String breakUpDurations) {
		this.breakUpDurations = breakUpDurations;
	}

	@Override
	public String toString() {
		return "ResponseModel [status=" + status + ", breakUpDurations=" + breakUpDurations + "]";
	}
	
	
	
	
}
