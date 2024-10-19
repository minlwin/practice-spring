package com.jdc.earthdistance.api.exceptions;

import java.util.List;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private List<String> errors;
	
	public ApiException(List<String> errors) {
		super();
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}
}
