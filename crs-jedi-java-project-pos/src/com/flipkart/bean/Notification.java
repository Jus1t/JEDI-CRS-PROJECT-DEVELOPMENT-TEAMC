package com.flipkart.bean;

public class Notification {
	private int userID;
	private int notificationID;
	private String content;
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getNotificationID() {
		return notificationID;
	}
	
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
