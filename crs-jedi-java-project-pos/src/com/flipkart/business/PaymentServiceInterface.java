package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.bean.PaymentNotification;

public interface PaymentServiceInterface {
	public boolean confirmPayment();

	public Payment getReceipt();

	public boolean cancelPayment();

}
