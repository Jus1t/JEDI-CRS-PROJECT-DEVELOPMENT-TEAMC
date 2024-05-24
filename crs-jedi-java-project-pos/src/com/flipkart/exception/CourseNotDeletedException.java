/**
 * 
 */
package com.flipkart.exception;

public class CourseNotDeletedException extends Exception {
	
	private String courseId;
	
	public CourseNotDeletedException(String courseCode)
	{	
		this.courseId = courseCode;
	}

	public String getCourseCode()
	{
		return courseId;
	}
	
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseId + " can't be deleted.";
	}
}