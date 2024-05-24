package com.flipkart.client;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.business.ProfessorServiceInterface;

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
		Scanner sc = new Scanner(System.in);
		ProfessorServiceInterface biz = new ProfessorServiceOperations();
		int a = 1;
		while (a != 0) {
			System.out.println("Enter the choice: ");
			System.out.println("1. Select course ");
			System.out.println("2. Submit grade ");
			System.out.println("3. View your courses ");
			System.out.println("4. View the Enrolled Students ");
			System.out.println("0. Exit ");
			a = sc.nextInt();

			switch (a) {
			case 0:
				return;
			case 1:
				
				System.out.println("Enter your courseId ");
				int courseId2 = sc.nextInt();
				biz.selectCourse(profId,courseId2);
				break;
			case 2:
				System.out.println("Enter studentId");
				int studentId=sc.nextInt();
				System.out.println("Enter courseId");
				int courseId=sc.nextInt();
				System.out.println("Enter grade");
				String grade=sc.next();
				biz.submitGrade(studentId,courseId,grade);
				break;
			case 3:
				ArrayList<Course>courseList=biz.getCoursesByProfessor(profId);
				for(Course c:courseList) {
					System.out.println(c.getCourseName());
				}
				break;
			case 4:
				ArrayList<EnrolledStudent>list=biz.getEnrolledStudents(profId);
				for(EnrolledStudent c:list) {
					System.out.println(c.getStudentId());
				}	
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}