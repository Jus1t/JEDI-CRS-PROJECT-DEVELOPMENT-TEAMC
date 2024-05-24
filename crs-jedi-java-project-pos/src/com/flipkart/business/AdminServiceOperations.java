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

/**
 * 
 */

public class AdminServiceOperations implements AdminServiceInterface {
	AdminDAOInterface adi = new AdminDAOImpl();
	public void addCourse(int id, String name, int instId,int courseFee) throws CourseExistsAlreadyException {
		
		if(AdminValidator.isValidNewCourse(name)==false)
		{
			System.out.println("Please enter the name of the course");
			return;
		}
		
		try {
			Course course = new Course(id, name, instId,courseFee);
			adi.addCourse(course);
		}catch (CourseExistsAlreadyException e) {
			throw e;
		}
	}

	public void deleteCourse(int id) throws CourseNotFoundException {
		adi.deleteCourse(id);
	}

	public ArrayList<Course> showCourses() {
		ArrayList<Course> x = adi.showCourses();
		return x;
	}

	public void closeRegistration(int id) {
		adi.closeRegistration(id);
	}

	public void assignCourse(int courseId, int instructorId) {
		adi.assignCourse(courseId, instructorId);
	}

	
	public void registerStudent(int id,String name,String phone,String email,String password,String branch,String batch) {
		Student st=new Student(id,name,phone,email,password,branch,batch);
		st.setRole("student");
		adi.registerStudent(st);
	}
	
	public String verifyCredentials(int id,String password) throws AuthenticationException {
		if(!(LoginValidator.isloginvalid(id,password)))
		{
			System.out.println("Enter the id or password");
			return null;
			
		}
		String role= adi.verifyCredentials(id, password);
		return role;
	}
	
	public void registerProfessor(int id,String name,String phone,String email,String password,String department,String designation) {
		Professor pro=new Professor(id,name,phone,email,password,department,designation);
		pro.setRole("professor");
		adi.registerProfessor(pro);
	}

	@Override
	public void approveStudent(int studentId) {
		// TODO Auto-generated method stub
		adi.approveStudent(studentId);
	}

	@Override
	public ArrayList<Student> viewUnapprovedRegistrations() {
		// TODO Auto-generated method stub
		ArrayList<Student>x=adi.viewUnapprovedRegistrations();
		return x;
	}

	@Override
	public ArrayList<Professor> viewProfessors() {
		// TODO Auto-generated method stub
		ArrayList<Professor>prof=adi.viewProfessors();
		return prof;
	}

	@Override
	public void approveCourse(int courseId,int studentId) {
		// TODO Auto-generated method stub
		adi.approveCourse(courseId,studentId);
		
	}

}