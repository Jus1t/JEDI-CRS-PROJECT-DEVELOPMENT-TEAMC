package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.flipkart.utils.*;
public class ProfessorDAOImpl implements ProfessorDAOInterface {
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();
	public void submitGrade(int studentId,int courseId,String grade) {
		statement = null;
		try {

			String sql = "insert into GradeCard(studentId, courseId, grade) values (?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			statement.setString(3, grade);
			int row = statement.executeUpdate();

			System.out.println(row + " grade submitted!");

		} catch (SQLException se) {
			System.out.println(se);
		}
	}
	
	public void selectCourse(int profId,int courseId) {
		statement = null;
		try {

			String sql = "insert into TeacherPreference(profId, courseId) values (?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, profId);
			statement.setInt(2, courseId);
			int row = statement.executeUpdate();

			System.out.println(row + " course preference added!");

		} catch (SQLException se) {
			System.out.println(se);
		}
	}
}
