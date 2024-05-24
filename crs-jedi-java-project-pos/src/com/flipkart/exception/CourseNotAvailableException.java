package com.flipkart.exception;


public class CourseNotAvailableException extends Exception{
	
	private String courseId;

	public CourseNotAvailableException(String courseId)
	{	
		this.courseId = courseId;
	}

	@Override
	public String getMessage() {
		return  "Seats are not available in : " + courseId;
	}


}