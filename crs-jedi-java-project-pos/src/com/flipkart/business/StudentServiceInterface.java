package com.flipkart.business;

import java.util.HashMap;

import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

public interface StudentServiceInterface {
	public void payBills(int id);

	public boolean registerCourse(int studentId, int courseId, String semester) throws CourseAlreadyRegisteredException, CourseLimitExceededException;

	public HashMap<Integer,String> viewResult(int id) throws GradeNotAllotedException;

	public void viewcatalogue(int sid);
}
