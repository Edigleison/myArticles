package com.edigleison.myarticles.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldValidationErrorDetails {

	private String erroTitle;
	private int erroStatus;
	private Long erroTimesTamp;
	private String erroPath;
	private String erroDeveloperMessage;
	private Map<String, List<FieldValidationError>> errors = new HashMap<>();

	public String getErroTitle() {
		return erroTitle;
	}

	public void setErroTitle(String erroTitle) {
		this.erroTitle = erroTitle;
	}

	public int getErroStatus() {
		return erroStatus;
	}

	public void setErroStatus(int erroStatus) {
		this.erroStatus = erroStatus;
	}

	public Long getErroTimesTamp() {
		return erroTimesTamp;
	}

	public void setErroTimesTamp(Long erroTimesTamp) {
		this.erroTimesTamp = erroTimesTamp;
	}

	public String getErroPath() {
		return erroPath;
	}

	public void setErroPath(String erroPath) {
		this.erroPath = erroPath;
	}

	public String getErroDeveloperMessage() {
		return erroDeveloperMessage;
	}

	public void setErroDeveloperMessage(String erroDeveloperMessage) {
		this.erroDeveloperMessage = erroDeveloperMessage;
	}

	public Map<String, List<FieldValidationError>> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, List<FieldValidationError>> errors) {
		this.errors = errors;
	}

}
