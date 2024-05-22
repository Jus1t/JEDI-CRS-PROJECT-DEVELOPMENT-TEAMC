package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;

import java.util.*;

/**
 * 
 */
public class CRSStudentMenu {
	public int studentid;
	public CRSStudentMenu(int id) {
		studentid = id;
	}

	/**
	 * @param args
	 */
	
	public void ShowOptions() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		StudentBusiness biz = new StudentBusiness();
		int a=1;
		while(a!=0)
		{
			System.out.println("Enter the choice: ");
			System.out.println("1. Register course ");
			System.out.println("2. View the result ");
			System.out.println("3. View the catalogue ");
			System.out.println("4. Pay Bills ");
			System.out.println("0. Exit ");
			a= sc.nextInt();
			
			switch(a)
			{
			case 0:
				return;
			case 1: 
				biz.registercourse(studentid);
				break;
			case 2:
				biz.viewresult(studentid);
				break;
			case 3:
				biz.viewcatalogue(studentid);
				break;
			case 4:
				biz.payBills(studentid);
				break;
			default:
				continue;
			}
		}
		

	}
	
}