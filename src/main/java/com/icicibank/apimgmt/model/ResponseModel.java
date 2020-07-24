package com.icicibank.apimgmt.model;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@XmlRootElement
@XmlType(propOrder = {"status","breakUpDurations","errorResponse"})
public class ResponseModel {
	
	
	private String status;
	

	private String breakUpDurations;
	
	
	@Autowired
	private ErrorResponseModel errorResponse;

	public ResponseModel() {
		
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

	public ErrorResponseModel getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseModel errorResponse) {
		this.errorResponse = errorResponse;
	}



	public ResponseModel(String status, String breakUpDurations, ErrorResponseModel errorResponse) {
		
		this.status = status;
		this.breakUpDurations = breakUpDurations;
		this.errorResponse = errorResponse;
	}

	@Override
	public String toString() {
		return "ResponseModel [status=" + status + ", breakUpDurations=" + breakUpDurations + ", errorResponse="
				+ errorResponse + "]";
	}
	
	
	
	
}
