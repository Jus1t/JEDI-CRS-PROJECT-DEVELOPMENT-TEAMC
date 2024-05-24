package com.flipkart.business;

public interface ProfessorServiceInterface {
	public void selectCourse(int profId,int courseId);

	public void submitGrade(int studentId,int courseId,String grade);
}
