package com.flipkart.business;

import com.flipkart.bean.Notification;

public class NotificationServiceOperations implements NotificationServiceInterface{
	public void sendPayFeesNotification() {
		Notification obj = new Notification();
		obj.getContent();
	}

	public void sendPaymentCompleteNotification(int transactionId, int studentid) {

	}
}