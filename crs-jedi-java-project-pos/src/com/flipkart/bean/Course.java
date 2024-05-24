package com.flipkart.bean;

public class Course {
	private int courseID;
	private String courseName;
	private int instructorID;
	private int enrolled_students;
	private boolean isOffered = true;
	private int courseFee;
	
	public boolean isOffered() {
		return isOffered;
	}

	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

	public Course() {

	}

	public Course(int id, String name, int instId, int courseFee) {
		this.courseID = id;
		this.courseName = name;
		this.instructorID = instId;
		this.courseFee = courseFee;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	public int getEnrolled_students() {
		return enrolled_students;
	}

	public void setEnrolled_students(int enrolled_students) {
		this.enrolled_students = enrolled_students;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
}