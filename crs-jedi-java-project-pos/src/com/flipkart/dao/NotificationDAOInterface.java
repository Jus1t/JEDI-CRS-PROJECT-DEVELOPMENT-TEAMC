package com.flipkart.dao;

public interface NotificationDAOInterface {
	public void sendNotifications(int notificationId, int userId, String content);
}
