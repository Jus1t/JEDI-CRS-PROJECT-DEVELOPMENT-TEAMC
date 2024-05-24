/**
 * 
 */
package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
	
	private int courseId;
	
	public CourseNotFoundException(int courseCode)
	{	
		this.courseId = courseCode;
	}


	public int getCourseCode()
	{
		return courseId;
	}
	

	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseId + " not found.";
	}
}