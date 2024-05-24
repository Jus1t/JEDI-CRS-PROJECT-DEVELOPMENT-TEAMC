package com.flipkart.dao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.GradeCard;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.utils.*;
public class StudentDAOImpl implements StudentDAOInterface {
	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();


	@Override
	public boolean registerCourse(int studentId, int courseId, String semester) throws SQLException, CourseLimitExceededException{
		// TODO Auto-generated method stub
		
		statement = null;
		Course x=null;
		try {

			String sql = "select courseId, courseName, instructorId, enrolledStudents, isOffered from Course where courseId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				x = new Course();
				x.setCourseID(resultSet.getInt(1));
				x.setCourseName(resultSet.getString(2));
				x.setInstructorID(resultSet.getInt(3));
				x.setEnrolled_students(resultSet.getInt(4));
				x.setOffered(resultSet.getBoolean(5));
			}

		} catch (SQLException se) {
			throw se;
		}
		
		if(x!=null && x.getEnrolled_students()>10) {
			throw new CourseLimitExceededException(courseId);
		}
		
		
		statement = null;
		try {

			String sql = "INSERT INTO RegisteredCourse(studentId, courseId, regDate, semester) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setString(4, semester);
			int row = statement.executeUpdate();

			System.out.println(row + " course registered");

		} catch (SQLException se) {
			System.out.println(se);
		}
		return true;
	}

	
	public HashMap<Integer,String> viewResult(int id) throws GradeNotAllotedException{
		HashMap<Integer,String> x=new HashMap<Integer,String>();
		statement = null;
		try {

			String sql = "select * from GradeCard where studentId=?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int courseId=resultSet.getInt(2); 
				String grade=resultSet.getString(3);
				if(grade==null) {
					throw new GradeNotAllotedException();
				}
				x.put(courseId, grade);
			}

		} catch (SQLException se) {
			System.out.println(se);
		}
		return x;
	}

	@Override
	public CourseCatalogue viewCatalogue() {
		// TODO Auto-generated method stub
		return null;
	}

}
