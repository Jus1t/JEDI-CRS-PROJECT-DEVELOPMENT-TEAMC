package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author JEDI-03 Interface for Admin Dao Operations
 *
 */
public interface AdminDAOInterface {

	public void addCourse(Course course) throws CourseExistsAlreadyException;

	public void deleteCourse(int id) throws CourseNotFoundException;

	public ArrayList<Course> showCourses();

	public void closeRegistration(int id);

	public void assignCourse(int courseId, int instructorId);

	public void registerStudent(Student student);

	public String verifyCredentials(int id, String password) throws AuthenticationException;

	public void registerProfessor(Professor prof);

	public void approveStudent(int studentId);
	
	public ArrayList<Student> viewUnapprovedRegistrations();
	
	public ArrayList<Professor> viewProfessors();
	
	public void approveCourse(int courseId,int studentId);

}