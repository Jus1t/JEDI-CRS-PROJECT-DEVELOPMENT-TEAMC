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

	public boolean registerCourse(int studentId, int courseId, String semester)
			throws SQLException, CourseLimitExceededException;

	public HashMap<Integer, String> viewResult(int id) throws GradeNotAllotedException;

	public boolean dropCourse(int courseId, int studentId) throws SQLException;

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
	public boolean seatAvailable(int courseId) throws SQLException;

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

}
