package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.ProfessorDAOImpl;
import com.flipkart.dao.ProfessorDAOInterface;

public class ProfessorServiceOperations implements ProfessorServiceInterface{

	public void selectCourse(int profId,int courseId) {
		ProfessorDAOInterface pdi=new ProfessorDAOImpl();
		pdi.selectCourse(profId, courseId);
	}

	public void submitGrade(int studentId,int courseId,String grade) {
		ProfessorDAOInterface pdi=new ProfessorDAOImpl();
		pdi.submitGrade(studentId, courseId, grade);
	}
	
	public ArrayList<Course> getCoursesByProfessor(int profId)
	{
		ProfessorDAOInterface pdi=new ProfessorDAOImpl();
		ArrayList<Course> courses= pdi.getCoursesByProfessor(profId);
		
		return courses;
		
	}
	
	public ArrayList<EnrolledStudent> getEnrolledStudents(int profId)
	{
		ProfessorDAOInterface pdi=new ProfessorDAOImpl();
		ArrayList<EnrolledStudent> students= pdi.getEnrolledStudents(profId);
		
		return students;
	}
}