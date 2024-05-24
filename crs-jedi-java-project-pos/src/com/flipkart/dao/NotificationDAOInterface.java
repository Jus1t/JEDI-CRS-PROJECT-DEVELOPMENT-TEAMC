/*
 * Interface: NotificationDAOInterface
 * Description: Interface for Notification Data Access Object (DAO) operations.
 * Author: Siddharth
 */
package com.flipkart.dao;

public interface NotificationDAOInterface {

    /**
     * Method: sendNotifications
     * Description: Sends notifications.
     * @param notificationId The ID of the notification.
     * @param userId The ID of the user to whom the notification is sent.
     * @param content The content of the notification.
     */
    public void sendNotifications(int notificationId, int userId, String content);
}
