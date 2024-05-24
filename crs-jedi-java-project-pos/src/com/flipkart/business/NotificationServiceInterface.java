/*
 * Interface: NotificationServiceInterface
 * Description: Interface for notification service operations.
 * Author: Siddharth and Saikat
 */
package com.flipkart.business;

public interface NotificationServiceInterface {
	/**
     * Method: sendNotifications
     * Description: Sends a notification to a user.
     * @param userId The ID of the user.
     * @param content The content of the notification.
     */
	public void sendNotifications(int userId,String content);
}
