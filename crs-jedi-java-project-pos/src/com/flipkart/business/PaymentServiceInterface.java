package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.bean.PaymentNotification;
import com.flipkart.exception.PaymentFailedException;

public interface PaymentServiceInterface {
	public boolean confirmPayment();

	public Payment getReceipt();

	public boolean cancelPayment();
	public boolean onlinePayment(int studentId,double amount,String bankName,String bankHolderName,String accountNo,String ifsc)throws PaymentFailedException ;
}
