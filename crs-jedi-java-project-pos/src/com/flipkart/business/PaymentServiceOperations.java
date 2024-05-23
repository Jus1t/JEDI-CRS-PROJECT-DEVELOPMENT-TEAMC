package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.bean.PaymentNotification;

public class PaymentServiceOperations implements PaymentServiceInterface {
	public boolean confirmPayment() {
		return true;
	}
	
	public Payment getReceipt() {
		return new Payment();
	}
	
	public boolean cancelPayment() {
		return false;
	}
	
}