package com.flipkart.business;
import com.flipkart.dao.*;
public class UserServiceOperations implements UserServiceInterface {
	public String getRole(String userId) {
		return "";
	}

	public void updatePassword(int userId,String oldPassword,String newPassword) {
		UserDAOInterface udi=new UserDAOImpl();
		udi.changePassword(userId, oldPassword, newPassword);
	}

	
	
}
