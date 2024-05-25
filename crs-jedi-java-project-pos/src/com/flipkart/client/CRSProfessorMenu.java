package com.flipkart.client;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.business.ProfessorServiceInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.flipkart.business.ProfessorServiceOperations;
/**
 * 
 */
public class CRSProfessorMenu {
	int profId;

	public CRSProfessorMenu(int id) {
		profId = id;
	}

	public void ShowOptions() {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime myDateObj = LocalDateTime.now();
		String formattedDate = myDateObj.format(myFormatObj);
		Scanner sc = new Scanner(System.in);
		ProfessorServiceInterface biz = new ProfessorServiceOperations();
		int a = 1;
		while (a != 0) {
			System.out.println("");
			System.out.println(formattedDate);
			System.out.println("\n--------------------------------");
			System.out.println("-------Professor Menu-----------");
			System.out.println("--------------------------------");
			System.out.println("1. Select course ");
			System.out.println("2. Submit grade ");
			System.out.println("3. View your courses ");
			System.out.println("4. View the Enrolled Students ");
			System.out.println("0. Log Out ");
			System.out.println("--------------------------------");
			System.out.printf("Choose From Menu: ");
			a = sc.nextInt();

			switch (a) {
			case 0:
				System.out.println("\n\nLogged Out\n\n");
				return;
			case 1:
				
				System.out.println("Enter CourseId ");
				int courseId2 = sc.nextInt();
				biz.selectCourse(profId,courseId2);
				break;
			case 2:
				System.out.println("Enter StudentId");
				int studentId=sc.nextInt();
				System.out.println("Enter CourseId");
				int courseId=sc.nextInt();
				System.out.println("Enter Grade");
				String grade=sc.next();
				biz.submitGrade(studentId,courseId,grade);
				break;
			case 3:
				ArrayList<Course>courseList=biz.getCoursesByProfessor(profId);
				System.out.println("\n\n+----------------------+------------+");
				System.out.println("|     Course Name      | Course ID  |");
				System.out.println("+----------------------+------------+");

				for (Course c : courseList) {
				    System.out.printf("| %-20s | %-10s |\n", c.getCourseName(), c.getCourseID());
				}
				break;
			case 4:
				ArrayList<EnrolledStudent>list=biz.getEnrolledStudents(profId);
				System.out.println("\n\n+------------+");
				System.out.println("| Student ID |");
				System.out.println("+------------+");

				for (EnrolledStudent c : list) {
				    System.out.printf("| %-10s |\n", c.getStudentId());
				}

				System.out.println("+------------+");

				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}

		}

	}

}