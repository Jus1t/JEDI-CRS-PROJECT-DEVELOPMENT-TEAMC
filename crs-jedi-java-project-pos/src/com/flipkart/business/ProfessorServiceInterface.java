package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

public interface ProfessorServiceInterface {
	public void selectCourse(int profId,int courseId);

	public void submitGrade(int studentId,int courseId,String grade);
	
	public ArrayList<Course> getCoursesByProfessor(int profId);
	
	public ArrayList<EnrolledStudent> getEnrolledStudents(int profId);
}
