package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface AdminServiceInterface {
	
	public void addCourse(int id);

	public void deleteCourse(int id);

	public ArrayList<Course> showCourses(int id);

	public void closeRegistration();

	public void assignCourse();
}
