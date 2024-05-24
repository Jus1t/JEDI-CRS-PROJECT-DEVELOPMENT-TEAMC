package com.flipkart.dao;

public interface UserDAOInterface {
	public void changePassword(int userId,String oldPassword,String newPassword);
}
