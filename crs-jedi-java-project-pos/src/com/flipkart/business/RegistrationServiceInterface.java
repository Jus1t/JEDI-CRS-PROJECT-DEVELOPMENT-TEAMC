package com.flipkart.business;

public interface RegistrationServiceInterface {
	public boolean addCourse(int courseId);

	public boolean dropCourse(int courseId);

	public double calculateFee(int studentId);

	public void viewGradeCard(int studentId);

	public void viewCourses(int studentId);

	public void viewRegisteredCourses(int studentId);

	public boolean getRegistrationStatus(int studentId);

	public void setRegistrationStatus(int studentId);
}
