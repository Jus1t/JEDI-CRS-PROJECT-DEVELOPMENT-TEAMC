package com.flipkart.bean;

public class Student extends User {
	private String branch;
	private String batch;

	public Student( int id, String name, String phone, String email, String password, String branch, String batch) {
		super(id,name, phone, email, password);
		this.branch = branch;
		this.batch = batch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

}