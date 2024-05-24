package com.flipkart.business;

public interface UserServiceInterface {
	public String getRole(String userId);

	public void updatePassword(int userId,String oldPassword,String newPassword);
}
