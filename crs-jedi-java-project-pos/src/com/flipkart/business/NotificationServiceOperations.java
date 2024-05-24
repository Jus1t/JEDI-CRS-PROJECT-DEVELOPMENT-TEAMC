package com.flipkart.business;
import com.flipkart.dao.*;

import java.util.Random;

import com.flipkart.bean.Notification;

public class NotificationServiceOperations implements NotificationServiceInterface{
	

	public void sendNotifications(int userId,String content) {
		int notificationId=new Random().nextInt(900000)+1000000;
		NotificationDAOInterface not=new NotificationDAOImpl();
		not.sendNotifications(notificationId, userId, content);
	}
}