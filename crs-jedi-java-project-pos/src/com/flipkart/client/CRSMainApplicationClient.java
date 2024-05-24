/**
 * 
 */
package com.flipkart.client;

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
		System.out.println("Hello, welcome to CRS Portal");
		int choice = 1;
		do {
			System.out.println("Enter choice... \n1. Login\n2. Student registration\n3. Change password/n0.Exit");
			choice = sc.nextInt();
			switch (choice) {
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
				return;
			}
		} while (choice != 0);

	}

	public static void RegisterStudent() {
		// String name, int id, String phone, String email, String password, String
		// branch, String batch
		System.out.println("Write name");
		String name = sc.next();
		System.out.println("Write id");
		int id = sc.nextInt();
		System.out.println("Write phone");
		String phone = sc.next();
		System.out.println("Write email");
		String email = sc.next();
		System.out.println("Write password");
		String password = sc.next();
		System.out.println("Write branch");
		String branch = sc.next();
		System.out.println("Write batch");
		String batch = sc.next();

		Student student = new Student(id, name, phone, email, password, branch, batch);
		AdminServiceInterface adi = new AdminServiceOperations();
		adi.registerStudent(id, name, phone, email, password, branch, batch);
		System.out.println("Registered succesfully");
	}

	public static void PrintStudents() {
		for (Student st : students.values()) {
			System.out.println(st.getName() + " " + st.getPassword());
		}
	}

	public static void ChangePassword() {
		System.out.println("Write id");
		int id = sc.nextInt();
		System.out.println("Write old password");
		String oldPW = sc.next();
		System.out.println("Write new password");
		String newPW = sc.next();
		UserServiceInterface adi = new UserServiceOperations();
		adi.updatePassword(id, oldPW, newPW);
		System.out.println("Password updated");
	}

	public static void loginUser() throws AuthenticationException {

		AdminServiceInterface adi = new AdminServiceOperations();
		System.out.println("Write userId");
		int id = sc.nextInt();
		System.out.println("Write password");
		String password = sc.next();
		String role = null;
		try {
		    role = adi.verifyCredentials(id, password);
		    
		    if (role == null) {
		        // Throw an exception if role is null
		    	System.out.println("Invalid credentials!");
		        throw new AuthenticationException();
		    }
		} catch (AuthenticationException e) {
		    throw e;
		}
//		if (role == null) {
//			System.out.println("Invalid credentials!");
//			return;
//		}

		switch (role) {
		case "professor":
			System.out.println("Logging as Professor ... ");
			CRSProfessorMenu profMenu = new CRSProfessorMenu(id);
			profMenu.ShowOptions();
			// prof menu
			break;
		case "student":
			System.out.println("Logging as Student ... ");
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
			System.out.println("Logging as an Admin ... ");
			CRSAdminMenu adMenu = new CRSAdminMenu(id);
			adMenu.ShowOptions();
			// admin menu
			break;
		}
	}
}
