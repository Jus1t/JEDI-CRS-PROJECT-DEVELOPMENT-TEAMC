/*
 * Interface: AdminServiceInterface
 * Description: Interface for admin service operations.
 * Author: Shivam and Hardik
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

public interface AdminServiceInterface {

	/**
     * Method: addCourse
     * Description: Adds a new course to the system.
     * @param id The ID of the course.
     * @param name The name of the course.
     * @param instId The ID of the instructor.
     * @param courseFee The fee of the course.
     * @throws CourseExistsAlreadyException If the course already exists.
     */
	public void addCourse(int id, String name, int instId,int courseFee) throws CourseExistsAlreadyException;

	 /**
     * Method: deleteCourse
     * Description: Deletes a course from the system.
     * @param id The ID of the course to be deleted.
     * @throws CourseNotFoundException If the course does not exist.
     */
	public void deleteCourse(int id) throws CourseNotFoundException;


    /**
     * Method: showCourses
     * Description: Retrieves all available courses.
     * @return An ArrayList containing all available courses.
     */
	public ArrayList<Course> showCourses();

	/**
     * Method: closeRegistration
     * Description: Closes registration for a course.
     * @param id The ID of the course for which registration is to be closed.
     */
	public void closeRegistration(int id);

	 /**
     * Method: assignCourse
     * Description: Assigns a course to an instructor.
     * @param courseId The ID of the course.
     * @param instructorId The ID of the instructor.
     */
	public void assignCourse(int courseId, int instructorId);

	/**
     * Method: registerStudent
     * Description: Registers a new student.
     * @param id The ID of the student.
     * @param name The name of the student.
     * @param phone The phone number of the student.
     * @param email The email of the student.
     * @param password The password of the student.
     * @param branch The branch of the student.
     * @param batch The batch of the student.
     */
	public void registerStudent(int id, String name, String phone, String email, String password, String branch,
			String batch);

	/**
     * Method: registerProfessor
     * Description: Registers a new professor.
     * @param id The ID of the professor.
     * @param name The name of the professor.
     * @param phone The phone number of the professor.
     * @param email The email of the professor.
     * @param password The password of the professor.
     * @param department The department of the professor.
     * @param designation The designation of the professor.
     */
	public void registerProfessor(int id, String name, String phone, String email, String password, String department,
			String designation);

    /**
     * Method: verifyCredentials
     * Description: Verifies login credentials.
     * @param id The ID of the user.
     * @param password The password of the user.
     * @return The role of the user if authentication is successful.
     * @throws AuthenticationException If authentication fails.
     */
	public String verifyCredentials(int id, String password) throws AuthenticationException;

	 /**
     * Method: approveStudent
     * Description: Approves a student registration.
     * @param studentId The ID of the student to be approved.
     */
	public void approveStudent(int studentId);

	 /**
     * Method: viewUnapprovedRegistrations
     * Description: Retrieves unapproved student registrations.
     * @return An ArrayList containing unapproved student registrations.
     */
	public ArrayList<Student> viewUnapprovedRegistrations();

	 /**
     * Method: viewProfessors
     * Description: Retrieves all registered professors.
     * @return An ArrayList containing all registered professors.
     */
	public ArrayList<Professor> viewProfessors();
	

    /**
     * Method: approveCourse
     * Description: Approves a course registration for a student.
     * @param courseId The ID of the course to be approved.
     * @param studentId The ID of the student for whom the course is to be approved.
     */
	public void approveCourse(int courseId,int studentId);

}
