/**
 * 
 */
package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
	
	private int courseCode;
	
	public CourseAlreadyRegisteredException(int courseCode) {
		this.courseCode = courseCode;
	}

	public int getCourseCode() {
		return courseCode;
	}

	@Override
	public String getMessage() {
		return "You have already registered for " + courseCode;
	}
}