/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.business.AdminServiceOperations;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

/**
 * 
 */
public class CRSAdminMenu {
	public int adminId;

	public CRSAdminMenu(int id) {
		adminId = id;
	}

	public void ShowOptions() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AdminServiceInterface biz = new AdminServiceOperations();
		int a = 1;
		while (a != 0) {
			System.out.println("Enter the choice: ");
			System.out.println("1. Add course ");
			System.out.println("2. Delete the course ");
			System.out.println("3. Close registration ");
			System.out.println("4. Show Courses ");
			System.out.println("5. Assign Courses ");
			System.out.println("6. Add Professor ");
			System.out.println("7. Approve Student ");
			System.out.println("8. View Pending Admission");
			System.out.println("0. Exit ");
			a = sc.nextInt();

			switch (a) {
			case 0:
				return;
			case 1:
				System.out.println("Enter courseId, name, instructorId...");
				int id = sc.nextInt();
				String name = sc.next();
				int instId = sc.nextInt();
				try {
					biz.addCourse(id,name,instId);
				}catch (CourseExistsAlreadyException e) {
					
					System.out.println(e.getMessage());
				}
				;
				break;
			case 2:
				System.out.println("Enter courseId");
				int course_id = sc.nextInt();
				try {
					biz.deleteCourse(course_id);
				}catch (CourseNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Enter courseId");
				int course_id1 = sc.nextInt();
				biz.closeRegistration(course_id1);
				break;
			case 4:
				ArrayList<Course> x = biz.showCourses();
				System.out.println("\n\n");	
				for(Course c : x) {
					System.out.println(c.getCourseName());
				}
				System.out.println("\n\n");
				break;
			case 5:
				System.out.println("Enter courseId");
				int course_id2 = sc.nextInt();
				System.out.println("Enter new instructorId");
				int instructorId = sc.nextInt();
				biz.assignCourse(course_id2,instructorId);
				break;
			case 6:
				System.out.println("Write professor name");
				name = sc.next();
				System.out.println("Write profId");
				id = sc.nextInt();
				System.out.println("Write phone");
				String phone = sc.next();
				System.out.println("Write email");
				String email = sc.next();
				System.out.println("Write password");
				String password = sc.next();
				System.out.println("Write designation");
				String designation = sc.next();
				System.out.println("Write department");
				String department = sc.next();

				Professor prof=new Professor(id, name, phone, email, password, department, designation);
				AdminServiceInterface adi=new AdminServiceOperations();
				adi.registerProfessor(id, name, phone, email, password, department, designation);
				System.out.println("Registered succesfully");
			default:
				continue;
			}
		}

	}
}
