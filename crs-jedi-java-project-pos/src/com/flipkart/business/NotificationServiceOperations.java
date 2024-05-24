/*
 * Class: NotificationServiceOperations
 * Description: Implements NotificationServiceInterface and provides operations for sending notifications.
 * Author: [Author's Name]
 */
package com.flipkart.business;
import com.flipkart.dao.*;

import java.util.Random;

import com.flipkart.bean.Notification;

public class NotificationServiceOperations implements NotificationServiceInterface{
	
	/**
     * Method: sendNotifications
     * Description: Sends a notification to a user.
     * @param userId The ID of the user.
     * @param content The content of the notification.
     */
	public void sendNotifications(int userId,String content) {
		int notificationId=new Random().nextInt(900000)+1000000;
		NotificationDAOInterface not=new NotificationDAOImpl();
		not.sendNotifications(notificationId, userId, content);
	}
}