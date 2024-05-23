package com.flipkart.business;

public interface NotificationServiceInterface {
	public void sendPaymentCompleteNotification(int transactionId, int studentid);
	public void sendPayFeesNotification() ;
}
