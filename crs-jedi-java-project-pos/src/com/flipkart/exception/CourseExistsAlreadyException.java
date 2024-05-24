/**
 * 
 */
package com.flipkart.exception;


public class CourseExistsAlreadyException extends Exception{
	
	private int courseCode;
	
	/***
	 * Constructor
	 * @param courseCode
	 */
	public CourseExistsAlreadyException(int courseCode) {
		this.courseCode = courseCode;
	}
	

	/**
	 * Getter method
	 * @return course code
	 */
	public int getCourseCode() {
		return courseCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course: " + courseCode + " already exists in catalog.";
	}
}