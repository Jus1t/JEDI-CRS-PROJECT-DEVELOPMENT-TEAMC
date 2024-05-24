package com.flipkart.exception;

public class AuthenticationException extends Exception{
	public String getMessage() {
		return "Authentication failed: check credentials";
	}
}
