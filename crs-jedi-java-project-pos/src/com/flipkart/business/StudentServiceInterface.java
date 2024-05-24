package com.flipkart.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

public interface StudentServiceInterface {
	public void payBills(int id);

	public boolean registerCourse(int studentId, int courseId, String semester) throws CourseAlreadyRegisteredException, CourseLimitExceededException;

	public HashMap<Integer,String> viewResult(int id) throws GradeNotAllotedException;

	public void viewcatalogue(int sid);
	
	public boolean dropCourse(int courseId, int studentId) throws SQLException;
	
	public ArrayList<Course> viewRegisteredCourses(int studentId) throws SQLException;
	
	public double calculateFee(int studentId) throws SQLException;
	
	public boolean seatAvailable(int courseId) throws SQLException;
	
	public boolean isRegistered(int courseCode, int studentId) throws SQLException;
	
	public boolean getRegistrationStatus(int studentId) throws SQLException;
	
	public ArrayList<Course> viewCourses(int studentId) throws SQLException;
}
