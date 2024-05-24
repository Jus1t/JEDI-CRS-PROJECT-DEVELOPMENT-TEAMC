package com.flipkart.bean;

/**
 * 
 * @author JEDI-03
 * Class for storing details of course Student has taken
 * 
 */
public class EnrolledStudent {
	private int courseId;
	private String courseName;
	private int studentId;
	
	/**
	 * Method to get Course Code
	 * @return Course Code
	 */
	public int getCourseCode() {
		return courseId;
	}
	
	/**
	 * Method to set Course Code
	 * @param courseCode: course code 
	 */
	public void setCourseCode(int courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * Method to get Course Name
	 * @return Course Name: course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Method to set Course Name
	 * @param courseName: course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id: student id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id of student enrolled in the course
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Parameterized constructor
	 * @param courseCode
	 * @param courseName
	 * @param studentId
	 */
	public EnrolledStudent(int courseId, String courseName, int studentId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
	}
}