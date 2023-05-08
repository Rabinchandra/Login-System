package com.rabin;

public class ResponseToClient {
	String error;
	boolean hasError;

	ResponseToClient(String error, boolean hasError) {
		this.error = error; 
		this.hasError = hasError;
	}
}