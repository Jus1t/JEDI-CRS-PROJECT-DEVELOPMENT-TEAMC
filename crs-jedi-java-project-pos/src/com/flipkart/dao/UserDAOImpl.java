package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.*;
public class UserDAOImpl implements UserDAOInterface{
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();
	public void changePassword(int userId,String oldPassword,String newPassword) {

		statement = null;
		try {

			String sql =SQLConstants.CHANGE_PASSWORD; 
			statement = connection.prepareStatement(sql);
			statement.setString(1, newPassword);
			statement.setInt(2, userId);
			statement.setString(3, oldPassword);
			
			int row = statement.executeUpdate();

			System.out.println(row + " Password Updated!");

		} catch (SQLException se) {
			System.out.println(se);
		}
	}

}
