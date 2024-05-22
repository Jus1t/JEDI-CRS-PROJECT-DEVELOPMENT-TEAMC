package com.flipkart.bean;

import java.util.HashMap;

public class GradeCard {
	private int studentId;
	private HashMap<Integer, Integer> grades;

	public GradeCard(int studentId) {
		this.studentId = studentId;
		this.grades = new HashMap<>();
	}

	public void addGrade(int courseId, int grade) {
		grades.put(courseId, grade);
	}

	public int getGrade(int courseId) {
		return grades.getOrDefault(courseId, -1); // Return -1 if course not found
	}

	// You can add more methods as needed

	// Getter and Setter for studentId if required
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}