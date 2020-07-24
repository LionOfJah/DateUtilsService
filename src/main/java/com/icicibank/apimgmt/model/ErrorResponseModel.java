package com.icicibank.apimgmt.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@XmlRootElement
public class ErrorResponseModel {
	
	
	private String errorCode;
	
	
	private String errorMessage;

	public ErrorResponseModel() {
		
	}

	public ErrorResponseModel( String errorCode, String errorMessage) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorResponseModel [ errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ "]";
	}
	
	
}
