package com.flipkart.dao;

public interface ProfessorDAOInterface   {
	public void selectCourse(int profId,int courseId);
	public void submitGrade(int studentId,int courseId,String grade) ;
}
