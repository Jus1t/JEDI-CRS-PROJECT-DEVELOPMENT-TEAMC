/**
 * 
 */
package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.business.*;
import com.flipkart.exception.AuthenticationException;
// notification, transaction, designation--->roles
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;

public class CRSMainApplicationClient {
	public static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		System.out.println("Hello, Welcome to CRS Portal!");
		int choice = 1;
		do {
			System.out.println("----------Welcome to Course Management System---------");
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update password");
			System.out.println("4. Exit");
			System.out.println("Enter your input");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				return;
			case 1:
				// login
				try {
					loginUser();
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				// registration
				RegisterStudent();
				break;
			case 3:
				// change pw
				ChangePassword();
				break;
			default:
				System.out.println("Invalid Input.");
				continue;
			}
		} while (choice != 0);

	}

	public static void RegisterStudent() {
		// String name, int id, String phone, String email, String password, String
		// branch, String batch
		System.out.println("---------------Student Registration-------------");
		System.out.println("Name");
		String name = sc.next();
		System.out.println("Id");
		int id = sc.nextInt();
		System.out.println("Phone");
		String phone = sc.next();
		System.out.println("Email");
		String email = sc.next();
		System.out.println("Password");
		String password = sc.next();
		System.out.println("Branch");
		String branch = sc.next();
		System.out.println("Batch");
		String batch = sc.next();

		Student student = new Student(id, name, phone, email, password, branch, batch);
		AdminServiceInterface adi = new AdminServiceOperations();
		adi.registerStudent(id, name, phone, email, password, branch, batch);
		System.out.println("Registered Succesfully!");
	}

	public static void PrintStudents() {
		for (Student st : students.values()) {
			System.out.println(st.getName() + " " + st.getPassword());
		}
	}

	public static void ChangePassword() {
		System.out.println("------------------Update Password--------------------");
		System.out.println("Id");
		int id = sc.nextInt();
		System.out.println("Old password");
		String oldPW = sc.next();
		System.out.println("New password");
		String newPW = sc.next();
		UserServiceInterface adi = new UserServiceOperations();
		adi.updatePassword(id, oldPW, newPW);
		System.out.println("Password Updated!");
	}

	public static void loginUser() throws AuthenticationException {
		System.out.println("-----------------Login------------------");
		AdminServiceInterface adi = new AdminServiceOperations();
		System.out.println("UserId");
		int id = sc.nextInt();
		System.out.println("Password");
		String password = sc.next();
		String role = null;
		try {
			role = adi.verifyCredentials(id, password);

			if (role == null) {
				// Throw an exception if role is null
				System.out.println("Invalid Credentials or Unapproved Students.");
//		        throw new AuthenticationException();
				return;
			}
		} catch (AuthenticationException e) {
//		    throw e;
		}
//		if (role == null) {
//			System.out.println("Invalid credentials!");
//			return;
//		}

		switch (role) {
		case "professor":
			System.out.println("Logged in Successfully as Professor");
			CRSProfessorMenu profMenu = new CRSProfessorMenu(id);
			profMenu.ShowOptions();
			// prof menu
			break;
		case "student":
			System.out.println("Logged in Successfully as Student");
			// student menu
			CRSStudentMenu stMenu = new CRSStudentMenu(id);
			try {
				stMenu.ShowOptions();
			} catch (CourseLimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {

			}
			break;
		case "admin":
			System.out.println("Logged in Successfully as Admin");
			CRSAdminMenu adMenu = new CRSAdminMenu(id);
			adMenu.ShowOptions();
			// admin menu
			break;
		}
	}
}
