package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.exception.PaymentFailedException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 */
public class CRSStudentMenu {
	public int studentId;

	public CRSStudentMenu(int id) {
		studentId = id;
	}

	/**
	 * @param args
	 * @throws CourseAlreadyRegisteredException
	 * @throws SQLException 
	 */

	public void ShowOptions() throws CourseAlreadyRegisteredException, CourseLimitExceededException, GradeNotAllotedException, SQLException {
		// TODO Auto-generated method stub
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime myDateObj = LocalDateTime.now();
		String formattedDate = myDateObj.format(myFormatObj);
		Scanner sc = new Scanner(System.in);
		StudentServiceInterface biz = new StudentServiceOperations();
		int a = 1;
		while (a != 0) {
			System.out.println("");
			System.out.println(formattedDate);
			System.out.println("\n*****************************");
			System.out.println("**********Student Menu*********");
			System.out.println("*****************************");
			System.out.println("1. Register course ");
			System.out.println("2. View the result ");
			System.out.println("3. View offered courses ");
			System.out.println("4. Pay Bills ");
			System.out.println("5. Drop Course ");
			System.out.println("6. View Added Courses ");
			System.out.println("7. Calculate Fee ");
			System.out.println("8. Seat Availability Check");
			System.out.println("9. Course Registration Status ");
			System.out.println("0. Log Out ");
			System.out.println("*****************************");
			System.out.printf("Choose From Menu: ");
			a = sc.nextInt();
			int courseId;
			switch (a) {
			case 0:
				System.out.println("\n\nLogged Out\n\n");
				return;
			case 1:
				System.out.println("1. Enter CourseId");
				courseId = sc.nextInt();
				System.out.println("1. Enter Semester");
				String semester = sc.next();
				try {
					biz.registerCourse(studentId, courseId, semester);
				} catch (CourseLimitExceededException e) {
					
					System.out.println(e.getMessage());
				}
				NotificationServiceInterface not = new NotificationServiceOperations();
				not.sendNotifications(studentId, "You have successfully registered for course!");
				break;
			case 2:
				HashMap<Integer, String> res=null;
				try {
					 res = biz.viewResult(studentId);
				}catch(GradeNotAllotedException e) {
					System.out.println(e.getMessage());
				}
				if (res==null || res.size()==0) {
					GradeNotAllotedException e = new GradeNotAllotedException();
					System.out.println(e.getMessage());
				}
				System.out.println("\n\n+-----------+------------+");
				System.out.println("| Course ID |   Grade    |");
				System.out.println("+-----------+------------+");

				for (Map.Entry<Integer, String> entry : res.entrySet()) {
				    System.out.printf("| %-10d| %-10s |\n", entry.getKey(), entry.getValue());
				}

				System.out.println("+-----------+------------+");

				break;
			case 3:
				StudentServiceInterface biz2 = new StudentServiceOperations();
				ArrayList<Course> x = biz2.viewCourses(studentId);
				System.out.println("\n\n+----------------------+------------+");
				System.out.println("|     Course Name      | Course ID  |");
				System.out.println("+----------------------+------------+");

				for (Course c : x) {
				    System.out.printf("| %-20s | %-10s |\n", c.getCourseName(), c.getCourseID());
				}

				System.out.println("+----------------------+------------+");

				break;
			case 4:
				System.out.println("Mode of Payment (online or offline)");
				String mode = sc.next();
				switch (mode) {
				case "offline":
					System.out.println("Please pay your bills to the nearest bank, will update you on success!");
					break;
				case "online":
					double fee = biz.calculateFee(studentId);
					System.out.println("Your course bill is "+fee);
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
						boolean result = psi.onlinePayment(studentId, fee, bankName, bankHolderName, accountNo, ifsc);
						if (result == false) {
							not1.sendNotifications(studentId, "Payment failed!");
							System.out.println("Payment failed!");
						} else {
							not1.sendNotifications(studentId, "Payment Successful!");
							System.out.println("Payment successful!");
						}
					}catch(PaymentFailedException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				break;
			case 5:
				System.out.println("Enter course id to drop");
				courseId=sc.nextInt();
				biz.dropCourse(courseId, studentId);
				break;
			case 6:
				ArrayList<Course> coursess = biz.viewRegisteredCourses(studentId);
				System.out.println("\n\n+----------------------+------------+");
				System.out.println("|     Course Name      | Course ID  |");
				System.out.println("+----------------------+------------+");

				for (Course c : coursess) {
				    System.out.printf("| %-20s | %-10s |\n", c.getCourseName(), c.getCourseID());
				}

				System.out.println("+----------------------+------------+");

//				System.out.println(coursess);
				break;
			case 7:
				double fee = biz.calculateFee(studentId);
				System.out.println("Total fee is " + fee);
				break;
			case 8:
				System.out.println("Enter your course id");
				courseId=sc.nextInt();
				boolean ans = biz.seatAvailable(courseId);
				if (ans)System.out.println("Seat is available.\n");
				else System.out.println("Sorry, no seats available.\n");
				
				break;
			case 9:
				System.out.println("Enter your course id");
				courseId=sc.nextInt();
				boolean ans1 = biz.isRegistered(courseId, studentId);
				String resword = ans1?"Registered":"Not registered";
				System.out.println("The course of id:"+courseId+" has status: "+resword);
				break;
			default:
				continue;
			}
		}

	}

}