package com.flipkart.client;
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
			System.out.println("0. Exit ");
			a = sc.nextInt();

			switch (a) {
			case 0:
				return;
			case 1:
				System.out.println("Enter your profId ");
				int profId2 = sc.nextInt();
				System.out.println("Enter your courseId ");
				int courseId2 = sc.nextInt();
				biz.selectCourse(profId2,courseId2);
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
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}