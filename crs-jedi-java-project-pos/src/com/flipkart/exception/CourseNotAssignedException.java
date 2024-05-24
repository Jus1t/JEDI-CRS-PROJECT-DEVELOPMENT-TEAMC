/**
 * 
 */
package com.flipkart.exception;

public class CourseNotAssignedException extends Exception{
	
	private String courseId;
	private String userId;
	
	public CourseNotAssignedException(String courseId, String userId) {
		this.courseId = courseId;
		this.userId = userId;
	}

	public String getCourseCode() {
		return courseId;
	}

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCourseCode(String courseCode) {
		this.courseId = courseCode;
	}

	@Override
	public String getMessage() {
		return "courseCode: " + courseId + " couldn't be assigned to UserId: " + userId ;
	}
}