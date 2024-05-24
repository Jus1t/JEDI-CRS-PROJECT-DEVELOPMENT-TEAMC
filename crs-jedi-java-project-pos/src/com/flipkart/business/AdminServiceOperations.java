package com.flipkart.business;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.validator.AdminValidator;
import com.flipkart.validator.LoginValidator;
import com.flipkart.dao.AdminDAOImpl;
import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;


public class AdminServiceOperations implements AdminServiceInterface {
	AdminDAOInterface adi = new AdminDAOImpl();
	
	/**
     * Method: addCourse
     * Description: Adds a new course to the system.
     * @param id The ID of the course.
     * @param name The name of the course.
     * @param instId The ID of the instructor.
     * @param courseFee The fee of the course.
     * @throws CourseExistsAlreadyException If the course already exists.
     */
	public void addCourse(int id, String name, int instId,int courseFee) throws CourseExistsAlreadyException {
		
		if(AdminValidator.isValidNewCourse(name)==false)
		{
			System.out.println("Please enter the course name");
			return;
		}
		
		try {
			Course course = new Course(id, name, instId,courseFee);
			adi.addCourse(course);
		}catch (CourseExistsAlreadyException e) {
			throw e;
		}
	}

	/**
     * Method: deleteCourse
     * Description: Deletes a course from the system.
     * @param id The ID of the course to be deleted.
     * @throws CourseNotFoundException If the course does not exist.
     */
	public void deleteCourse(int id) throws CourseNotFoundException {
		adi.deleteCourse(id);
	}

	/**
     * Method: showCourses
     * Description: Retrieves all available courses.
     * @return An ArrayList containing all available courses.
     */
	public ArrayList<Course> showCourses() {
		ArrayList<Course> x = adi.showCourses();
		return x;
	}

	 /**
     * Method: closeRegistration
     * Description: Closes registration for a course.
     * @param id The ID of the course for which registration is to be closed.
     */
	public void closeRegistration(int id) {
		adi.closeRegistration(id);
	}

	/**
     * Method: assignCourse
     * Description: Assigns a course to an instructor.
     * @param courseId The ID of the course.
     * @param instructorId The ID of the instructor.
     */
	public void assignCourse(int courseId, int instructorId) {
		adi.assignCourse(courseId, instructorId);
	}

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
	public void registerStudent(int id,String name,String phone,String email,String password,String branch,String batch) {
		Student st=new Student(id,name,phone,email,password,branch,batch);
		st.setRole("student");
		adi.registerStudent(st);
	}
	
	 /**
     * Method: verifyCredentials
     * Description: Verifies login credentials.
     * @param id The ID of the user.
     * @param password The password of the user.
     * @return The role of the user if authentication is successful.
     * @throws AuthenticationException If authentication fails.
     */
	public String verifyCredentials(int id,String password) throws AuthenticationException {
		if(!(LoginValidator.isloginvalid(id,password)))
		{
			System.out.println("Enter the id or password");
			return null;
			
		}
		String role= adi.verifyCredentials(id, password);
		return role;
	}
	
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
	public void registerProfessor(int id,String name,String phone,String email,String password,String department,String designation) {
		Professor pro=new Professor(id,name,phone,email,password,department,designation);
		pro.setRole("professor");
		adi.registerProfessor(pro);
	}

	/**
     * Method: approveStudent
     * Description: Approves a student registration.
     * @param studentId The ID of the student to be approved.
     */
	@Override
	public void approveStudent(int studentId) {
		// TODO Auto-generated method stub
		adi.approveStudent(studentId);
	}

	/**
     * Method: viewUnapprovedRegistrations
     * Description: Retrieves unapproved student registrations.
     * @return An ArrayList containing unapproved student registrations.
     */
	@Override
	public ArrayList<Student> viewUnapprovedRegistrations() {
		// TODO Auto-generated method stub
		ArrayList<Student>x=adi.viewUnapprovedRegistrations();
		return x;
	}

	 /**
     * Method: viewProfessors
     * Description: Retrieves all registered professors.
     * @return An ArrayList containing all registered professors.
     */
	@Override
	public ArrayList<Professor> viewProfessors() {
		// TODO Auto-generated method stub
		ArrayList<Professor>prof=adi.viewProfessors();
		return prof;
	}

	/**
     * Method: approveCourse
     * Description: Approves a course registration for a student.
     * @param courseId The ID of the course to be approved.
     * @param studentId The ID of the student for whom the course is to be approved.
     */
	@Override
	public void approveCourse(int courseId,int studentId) {
		// TODO Auto-generated method stub
		adi.approveCourse(courseId,studentId);
		
	}

}