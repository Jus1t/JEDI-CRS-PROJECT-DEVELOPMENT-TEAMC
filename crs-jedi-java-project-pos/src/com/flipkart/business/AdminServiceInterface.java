package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

public interface AdminServiceInterface {
	
	public void addCourse(int id, String name, int instId)throws CourseExistsAlreadyException;

	public void deleteCourse(int id) throws CourseNotFoundException;

	public ArrayList<Course> showCourses();

	public void closeRegistration(int id);

	public void assignCourse(int courseId, int instructorId);
	
	public void registerStudent(int id,String name,String phone,String email,String password,String branch,String batch);
	
	public void registerProfessor(int id,String name,String phone,String email,String password,String department,String designation);
	
	public String verifyCredentials(int id,String password) throws AuthenticationException;
	
}
