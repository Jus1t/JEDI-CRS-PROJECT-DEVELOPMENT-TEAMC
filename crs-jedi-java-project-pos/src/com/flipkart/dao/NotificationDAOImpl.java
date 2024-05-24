package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.*;

public class NotificationDAOImpl implements NotificationDAOInterface {
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();

	public void sendNotifications(int notificationId,int userId,String content) {
		statement = null;
		try {

			String sql = SQLConstants.NOTIFICATION_SEND;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, notificationId);
			statement.setInt(2, userId);
			statement.setString(3, content);
			int row = statement.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se);
			
		}
	}

	
}
