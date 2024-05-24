package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.exception.PaymentFailedException;
import com.flipkart.utils.*;

public class PaymentDAOImpl implements PaymentDAOInterface{
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();
	public boolean onlinePayment(int paymentId,int studentId,double amount,String bankName,String bankHolderName,String accountNo,String ifsc) throws PaymentFailedException {
		statement = null;
		try {

			String sql = "insert into Payment(paymentId,studentId,amount, paymentMode) values (?, ?, ?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, paymentId);
			statement.setInt(2, studentId);
			statement.setDouble(3, amount);
			statement.setString(4, "online");
			int row = statement.executeUpdate();


		} catch (SQLException se) {
			PaymentFailedException exc=new PaymentFailedException();
			System.out.println(exc.getMessage());
			return false;
		}
		
		statement = null;
		try {

			String sql = "insert into BankDetails(paymentId,bankName,bankHolderName,ifsc,accountNo) values (?, ?, ?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, paymentId);
			statement.setString(2, bankName);
			statement.setString(3, bankHolderName);
			statement.setString(4, ifsc);
			statement.setString(5, accountNo);
			int row = statement.executeUpdate();

		} catch (SQLException se) {
			PaymentFailedException exc=new PaymentFailedException();
			System.out.println(exc.getMessage());
			return false;
		}
		return true;
	}
}
