package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.exception.PaymentFailedException;

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
	 * @throws CourseAlreadyRegisteredException
	 */

	public void ShowOptions() throws CourseAlreadyRegisteredException, CourseLimitExceededException, GradeNotAllotedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StudentServiceInterface biz = new StudentServiceOperations();
		int a = 1;
		while (a != 0) {
			System.out.println("Enter the choice: ");
			System.out.println("1. Register course ");
			System.out.println("2. View the result ");
			System.out.println("3. View the catalogue ");
			System.out.println("4. Pay Bills ");
			System.out.println("0. Exit ");
			a = sc.nextInt();

			switch (a) {
			case 0:
				return;
			case 1:
				System.out.println("1. Enter studentId");
				int studentId = sc.nextInt();
				System.out.println("1. Enter courseId");
				int courseId = sc.nextInt();
				System.out.println("1. Enter semester");
				String semester = sc.next();
				try {
					biz.registerCourse(studentid, courseId, semester);
				} catch (CourseLimitExceededException e) {
					System.out.println(e.getMessage());
				}
				NotificationServiceInterface not = new NotificationServiceOperations();
				not.sendNotifications(studentId, "You have successfully registered for course!");
				break;
			case 2:
				System.out.println("1. Enter your studentId");
				HashMap<Integer, String> res=null;
				int studentId1 = sc.nextInt();
				try {
					 res = biz.viewResult(studentId1);
				}catch(GradeNotAllotedException e) {
					System.out.println(e.getMessage());
				}
				if (res==null || res.size()==0) {
					GradeNotAllotedException e = new GradeNotAllotedException();
					System.out.println(e.getMessage());
				}
				for (Map.Entry<Integer, String> entry : res.entrySet()) {
					System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
				}
				break;
			case 3:
				AdminServiceInterface biz2 = new AdminServiceOperations();
				ArrayList<Course> x = biz2.showCourses();
				System.out.println("\n\n");
				for (Course c : x) {
					System.out.println(c.getCourseName());
				}
				System.out.println("\n\n");
				break;
			case 4:
				System.out.println("Choose your mode of payment (online or offline)");
				String mode = sc.next();
				switch (mode) {
				case "offline":
					System.out.println("Please pay your bills to the nearest bank, will update you on success!");
					break;
				case "online":
					System.out.println("Enter your studentId");
					int studentId2 = sc.nextInt();
					System.out.println("Course is for $6000");
					System.out.println("Enter your bank name");
					String bankName = sc.next();
					System.out.println("Enter your account holder name");
					String bankHolderName = sc.next();
					System.out.println("Enter your account no.");
					String accountNo = sc.next();
					System.out.println("Enter your ifsc code");
					String ifsc = sc.next();

					PaymentServiceInterface psi = new PaymentServiceOperations();
					NotificationServiceInterface not1 = new NotificationServiceOperations();
					try {
						boolean result = psi.onlinePayment(studentId2, 6000, bankName, bankHolderName, accountNo, ifsc);
						if (result == false) {
							not1.sendNotifications(studentId2, "Payment failed!");
							System.out.println("Payment failed!");
						} else {
							not1.sendNotifications(studentId2, "Payment Successful!");
							System.out.println("Payment successful!");
						}
					}catch(PaymentFailedException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				break;
			default:
				continue;
			}
		}

	}

}