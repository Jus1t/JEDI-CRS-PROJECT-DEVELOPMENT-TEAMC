package com.flipkart.business;

public interface UserServiceInterface {
	public String getRole(String userId);

	public boolean updatePassword(String userID, String newPassword);

	public boolean verifyCredentials(String userID, String password);
}
