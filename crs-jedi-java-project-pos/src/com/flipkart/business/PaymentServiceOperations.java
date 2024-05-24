package com.flipkart.business;

import java.util.Random;

import com.flipkart.bean.Payment;
import com.flipkart.dao.*;
import com.flipkart.bean.PaymentNotification;
import com.flipkart.dao.PaymentDAOInterface;
import com.flipkart.exception.PaymentFailedException;

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
	
	public boolean onlinePayment(int studentId,double amount,String bankName,String bankHolderName,String accountNo,String ifsc) throws PaymentFailedException{
		int paymentId=new Random().nextInt(9000000)+100000;
		PaymentDAOInterface pid=new PaymentDAOImpl();
		return pid.onlinePayment(paymentId, studentId, amount, bankName, bankHolderName, accountNo, ifsc);
	}
	
}