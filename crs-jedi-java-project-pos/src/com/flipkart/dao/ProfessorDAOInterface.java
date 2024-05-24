package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;

public interface ProfessorDAOInterface   {
	public void selectCourse(int profId,int courseId);
	public void submitGrade(int studentId,int courseId,String grade) ;
	public ArrayList<Course> getCoursesByProfessor(int profId);
	
	
	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	public ArrayList<EnrolledStudent> getEnrolledStudents(int profId);
	

	/**
	 * Method to Get professor name by id
	 * @param profId
	 * @return Professor Id in string
	 */
}
