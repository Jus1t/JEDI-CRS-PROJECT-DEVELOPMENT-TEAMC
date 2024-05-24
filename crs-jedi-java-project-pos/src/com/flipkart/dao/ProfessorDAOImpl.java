package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.*;
public class ProfessorDAOImpl implements ProfessorDAOInterface {
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();
	public void submitGrade(int studentId,int courseId,String grade) {
		statement = null;
		try {

			String sql = SQLConstants.GRADE_CARD_INSERTION;
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

			String sql = SQLConstants.TEACHER_PREFERENCE_INSERTION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, profId);
			statement.setInt(2, courseId);
			int row = statement.executeUpdate();

			System.out.println(row + " course preference added!");

		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	@Override
	public ArrayList<Course> getCoursesByProfessor(int profId) {
		ArrayList<Course> courseList = new  ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_COURSES);
			
			statement.setInt(1, profId);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getInt("courseID"),results.getString("courseName"),results.getInt("instructorId"),results.getInt("courseFee")));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return courseList;
	}

	@Override
	public ArrayList<EnrolledStudent> getEnrolledStudents(int profId) {
		statement = null;
		ArrayList<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try {
			statement = connection.prepareStatement(SQLConstants.GET_ENROLLED_STUDENTS);
			statement.setInt(1, profId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				//int id, String name, String phone, String email, String password, String branch, String batch
				enrolledStudents.add(new EnrolledStudent(results.getInt("courseId"),results.getString("courseName"),results.getInt("studentId")));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return enrolledStudents;
	}

}
