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
	public void payBills(int id) {
		System.out.println("Bill payment");
	}

	public HashMap<Integer, String> viewResult(int id) throws GradeNotAllotedException{
		try {
			StudentDAOInterface sdi = new StudentDAOImpl();
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
			StudentDAOInterface sdi = new StudentDAOImpl();
			res = sdi.registerCourse(studentId, courseId, semester);
		} catch (SQLException x) {
			throw new CourseLimitExceededException(courseId);
		}
		return res;
	}

}