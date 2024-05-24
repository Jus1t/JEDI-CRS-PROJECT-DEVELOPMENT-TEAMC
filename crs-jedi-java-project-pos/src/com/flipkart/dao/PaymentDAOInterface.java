package com.flipkart.dao;

import com.flipkart.exception.PaymentFailedException;

public interface PaymentDAOInterface {
	public boolean onlinePayment(int paymentId,int studentId,double amount,String bankName,String bankHolderName,String accountNo,String ifsc) throws PaymentFailedException ;
}
