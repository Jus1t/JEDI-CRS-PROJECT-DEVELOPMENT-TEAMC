package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.GradeCard;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

public interface StudentDAOInterface {

	public CourseCatalogue viewCatalogue();

	public boolean registerCourse(int studentId, int courseId, String semester)
			throws SQLException, CourseLimitExceededException;

	public HashMap<Integer, String> viewResult(int id) throws GradeNotAllotedException;

	public boolean dropCourse(String courseCode, int studentId) throws SQLException;

	/**
	 * Method to get the list of courses available from course catalog
	 * 
	 * @param studentId
	 * @return list of Courses
	 * @throws SQLException
	 */
	public ArrayList<Course> viewCourses(int studentId) throws SQLException;

	/**
	 * Method to View list of Registered Courses
	 * 
	 * @param studentId
	 * @return list of Registered Courses
	 * @throws SQLException
	 */
	public ArrayList<Course> viewRegisteredCourses(int studentId) throws SQLException;

	/**
	 * Method to view grade card of the student
	 * 
	 * @param studentId
	 * @return Grade Card
	 * @throws SQLException
	 */

	public double calculateFee(int studentId) throws SQLException;

	/**
	 * Check if seat is available for that particular course
	 * 
	 * @param courseCode
	 * @return seat availability status
	 * @throws SQLException
	 */
	public boolean seatAvailable(String courseCode) throws SQLException;

	/**
	 * Method to get the list of courses registered by the student Number of
	 * registered courses for a student
	 * 
	 * @param studentId
	 * @return Number of registered Courses
	 * @throws SQLException
	 */
	public int numOfRegisteredCourses(int studentId) throws SQLException;

	/**
	 * Method checks if the student is registered for that course
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return Students registration status
	 * @throws SQLException
	 */
	public boolean isRegistered(String courseCode, int studentId) throws SQLException;

	/**
	 * Method to get student registration status
	 * 
	 * @param studentId
	 * @return Student's registration status
	 * @throws SQLException
	 */
	public boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * Method to set student registration status
	 * 
	 * @param studentId
	 * @throws SQLException
	 */
	public void setRegistrationStatus(int studentId) throws SQLException;
}
