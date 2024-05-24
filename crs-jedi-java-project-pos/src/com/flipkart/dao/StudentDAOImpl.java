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
import com.flipkart.bean.Professor;
import com.flipkart.constants.SQLConstants;
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

			String sql = SQLConstants.REGISTER_COURSE;
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
				x.setCourseFee(resultSet.getInt(6));
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
	public boolean dropCourse(int courseId, int studentId) throws SQLException {
		statement = null;
		Course x=null;
		try {

			String sql = SQLConstants.DROP_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			statement.setInt(2, studentId);

			int rows = statement.executeUpdate();
			
			System.out.println(rows + " course dropped");
		} catch (SQLException se) {
			return false;
		}
		
	
		return true;
	}



	@Override
	public ArrayList<Course> viewRegisteredCourses(int studentId) throws SQLException {
		statement = null;
		ArrayList<Course> regCourselist = new ArrayList<>();
		try {
			
			String sql = SQLConstants.VIEW_REGISTERED_COURSES;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseID(resultSet.getInt(1));
				course.setCourseName(resultSet.getString(2));
				course.setInstructorID(resultSet.getInt(3));
				course.setEnrolled_students(resultSet.getInt(4));
				course.setOffered(resultSet.getBoolean(5));
				regCourselist.add(course);
				
			}
			
			System.out.println(regCourselist.size() + " courses are registered by you.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
		return regCourselist;
	}


	@Override
	public double calculateFee(int studentId) throws SQLException {
		double fee = 0;
		statement=null;
		try
		{
			statement = connection.prepareStatement(SQLConstants.CALCULATE_FEES);
			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			fee = rs.getDouble(1);
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			statement.close();
			connection.close();
		}
		
		return fee;
	}


	@Override
	public boolean seatAvailable(int courseId) throws SQLException {
		int seats = 0;
		statement=null;
		try
		{
			statement = connection.prepareStatement(SQLConstants.GET_SEATS);
			statement.setInt(1, courseId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			seats = rs.getInt(1);
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			statement.close();
			connection.close();
		}
		
		return seats<10;
	}


	@Override
	public boolean isRegistered(String courseCode, int studentId) throws SQLException {
		statement = null;
		try {

			String sql = SQLConstants.IS_REGISTERED;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);

			int rows = statement.executeUpdate();
			
			if (rows>0) {
				return true;
			}
		} catch (SQLException se) {
			
			return false;
		}
		
		return false;
	}	


	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		statement = null;
		Course x=null;
		try {

			String sql = SQLConstants.GET_REGISTRATION_STATUS;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);

			int rows = statement.executeUpdate();
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			boolean res = rs.getBoolean(1);
			return res;
		} catch (SQLException se) {
			return false;
		}
		
	
	}

}
