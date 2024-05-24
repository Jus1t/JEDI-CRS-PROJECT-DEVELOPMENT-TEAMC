package com.flipkart.business;

import com.flipkart.dao.*;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;

public class StudentServiceOperations implements StudentServiceInterface {
	StudentDAOInterface sdi = new StudentDAOImpl();
	public void payBills(int id) {
		System.out.println("Bill payment");
	}

	public HashMap<Integer, String> viewResult(int id) throws GradeNotAllotedException{
		try {
//			StudentDAOInterface sdi = new StudentDAOImpl();
			return sdi.viewResult(id);
		}catch (GradeNotAllotedException e) {
			throw e;
		}
		
	}

	public void viewcatalogue(int sid) {
		System.out.println("Course catalog");
	}

	public boolean registerCourse(int studentId, int courseId, String semester) throws CourseAlreadyRegisteredException, CourseLimitExceededException {
		boolean res = false;
		try {
//			StudentDAOInterface sdi = new StudentDAOImpl();
			res = sdi.registerCourse(studentId, courseId, semester);
		} catch (SQLException x) {
			throw new CourseLimitExceededException(courseId);
		}
		return res;
	}

	@Override
	public boolean dropCourse(int courseId, int studentId) throws SQLException {
		// 
		boolean isDrop=sdi.dropCourse(courseId, studentId)
		return isDrop;
	}

	@Override
	public ArrayList<Course> viewRegisteredCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Course>courseList=sdi.viewRegisteredCourses(studentId);
		return courseList;
	}

	@Override
	public double calculateFee(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		double fees=sdi.calculateFee(studentId);
		return fees;
	}

	@Override
	public boolean seatAvailable(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		boolean seatsAvailable=sdi.seatAvailable(courseId);
		return seatsAvailable;
	}

	@Override
	public boolean isRegistered(int courseId, int studentId) throws SQLException {
		// TODO Auto-generated method stub
		boolean isRegis=sdi.isRegistered(courseId, studentId);
		return isRegis;
	}

	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		boolean status=sdi.getRegistrationStatus(studentId);
		return status;
	}

}