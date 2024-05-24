package com.flipkart.validator;

import java.util.List;

import com.flipkart.bean.Course;

public class AdminValidator {

	public static boolean isValidNewCourse(String courseName) {
		
		if(courseName==null) return false;
		return true;
	}
}
