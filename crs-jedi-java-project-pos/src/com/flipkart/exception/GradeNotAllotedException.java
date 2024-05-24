/**
 * 
 */
package com.flipkart.exception;


public class GradeNotAllotedException extends Exception{
	 	 

	 public GradeNotAllotedException()
	 {
	 }

	 public String getMessage() 
	 {
			return "Student hasn't been alloted a grade yet";
	 }
}