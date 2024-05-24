package com.flipkart.bean;

public class Professor extends User {
	private String department;
	private String designation;

	public Professor(int id,String name, String phone, String email, String password, String department,
			String designation) {
		super(id, name, phone, email, password);
		this.department = department;
		this.designation = designation;
		// TODO Auto-generated constructor stub
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}