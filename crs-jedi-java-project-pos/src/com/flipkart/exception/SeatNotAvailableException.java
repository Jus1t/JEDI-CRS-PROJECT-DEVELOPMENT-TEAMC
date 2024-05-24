package com.flipkart.exception;


public class SeatNotAvailableException extends Exception{
	
	private String courseId;


	public SeatNotAvailableException(String courseCode)
	{	
		this.courseId = courseCode;
	}



	@Override
	public String getMessage() {
		return  "Seats are not available in : " + courseId;
	}


}