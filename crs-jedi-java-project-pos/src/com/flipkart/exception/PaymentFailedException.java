package com.flipkart.exception;

public class PaymentFailedException extends Exception {

	public String getMessage() 
	 {
			return "Payment failed";
	 }
}
