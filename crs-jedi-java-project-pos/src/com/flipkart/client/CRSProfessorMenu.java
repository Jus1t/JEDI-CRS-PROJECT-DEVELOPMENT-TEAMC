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
				biz.selectcourse(profId);
				break;
			case 2:
				biz.submitgrade(profId);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}