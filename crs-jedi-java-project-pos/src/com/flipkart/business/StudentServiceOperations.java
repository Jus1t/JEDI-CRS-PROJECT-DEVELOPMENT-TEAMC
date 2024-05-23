package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public class StudentServiceOperations implements StudentServiceInterface {
	public void payBills(int id) {
		System.out.println("Bill payment");
	}

	public void registercourse(int sid) {
		System.out.println("Course registration");
	}

	public void viewresult(int sid) {
		System.out.println("Show result");
	}

	public void viewcatalogue(int sid) {
		System.out.println("Course catalog");
	}

}