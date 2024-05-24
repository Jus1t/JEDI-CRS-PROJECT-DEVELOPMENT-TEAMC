package com.flipkart.dao;

import java.sql.Connection;
import com.flipkart.utils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author JEDI-03 Dao Class Operations for Admin
 * 
 */
public class AdminDAOImpl implements AdminDAOInterface {

	private PreparedStatement statement = null;

	Connection connection = DBUtils.getConnection();

	public ArrayList<Course> showCourses() {

		statement = null;
		ArrayList<Course> courseList = new ArrayList<>();
		try {

//			String sql = "select courseId, courseName, instructorId from Course";
			String sql=SQLConstants.COURSE_DETAILS;
			statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Course course = new Course();
				course.setCourseID(resultSet.getInt(1));
				course.setCourseName(resultSet.getString(2));
				course.setInstructorID(resultSet.getInt(3));
				course.setEnrolled_students(resultSet.getInt(4));
				course.setOffered(resultSet.getBoolean(5));
				course.setCourseFee(resultSet.getInt(6));
				courseList.add(course);

			}

		} catch (SQLException se) {
			System.out.print(se);
		}

		return courseList;

	}

	@Override
	public void addCourse(Course course) throws CourseExistsAlreadyException {

		statement = null;
		try {

//			String sql = "insert into Course(courseId, courseName, instructorId, enrolledStudents, isOffered) values (?, ?, ?, ?, ?)";
			String sql=SQLConstants.COURSE_INSERTION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, course.getCourseID());
			statement.setString(2, course.getCourseName());
			statement.setInt(3, course.getInstructorID());
			statement.setInt(4, course.getEnrolled_students());
			statement.setBoolean(5, course.isOffered());
			int row = statement.executeUpdate();

			System.out.println(row + " course added");

		} catch (SQLException se) {
			throw new CourseExistsAlreadyException(course.getCourseID());
		}

	}

	@Override
	public void deleteCourse(int id) throws CourseNotFoundException{
		statement = null;
		try {

//			String sql = "delete from Course where courseId = ?";
			String sql=SQLConstants.COURSE_DELETION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			int row = statement.executeUpdate();
			
			if(row==0)
			{
				System.out.println("Course not found");
		        throw new CourseNotFoundException(id);
			}

			System.out.println(row + " course deleted");
			
			

		} catch (SQLException se) {
			throw new CourseNotFoundException(id);
			
		}

	}

	@Override
	public void closeRegistration(int id) {
		// TODO Auto-generated method stub
		statement = null;
		try {

//			String sql = "update Course set isOffered=false where courseId = ?";
			String sql=SQLConstants.CLOSE_REGISTRATION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			int row = statement.executeUpdate();

			System.out.println(row + " course closed");

		} catch (SQLException se) {
			System.out.println(se);
		}

	}

	@Override
	public void assignCourse(int courseId, int instructorId) {
		// TODO Auto-generated method stub
		statement = null;
		try {

//			String sql = "update Course set instructorId=? where courseId = ?";
			String sql=SQLConstants.ASSIGN_COURSE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, instructorId);
			statement.setInt(2, courseId);
			int row = statement.executeUpdate();

			System.out.println(row + " course assigned");

		} catch (SQLException se) {
			System.out.println(se);
		}

	}

	public void registerStudent(Student student) {
		statement = null;
		try {

//			String sql = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
			String sql=SQLConstants.INSERT_USER;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getPhone());
			statement.setString(4, student.getEmail());
			statement.setString(5, student.getPassword());
			statement.setString(6, student.getRole());
			statement.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se);
		}

		try {

//			String sql = "insert into Student(studentId,branch,batch) values (?, ?, ?)";
			String sql=SQLConstants.INSERT_STUDENT;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.setString(2, student.getBranch());
			statement.setString(3, student.getBatch());
			int row = statement.executeUpdate();

			System.out.println(row + " student added");

		} catch (SQLException se) {
			System.out.println(se);
		}

	}
	
	public String verifyCredentials(int id,String password) throws AuthenticationException{
		statement = null;
		ResultSet resultSet = null;
		String role = null;

		try {

//			String sql = "select * from User where userId=? AND password=?";
			String sql=SQLConstants.VERIFY_CREDENTIALS;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			  if (resultSet.next()) {
		            // User exists with given credentials
				  role = resultSet.getString("role");
		        }

		} catch (SQLException se) {
			System.out.println(se);
		}

		return role;
	}

	
	public void registerProfessor(Professor prof) {
		statement = null;
		try {

//			String sql = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
			String sql=SQLConstants.INSERT_USER;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, prof.getId());
			statement.setString(2, prof.getName());
			statement.setString(3, prof.getPhone());
			statement.setString(4, prof.getEmail());
			statement.setString(5, prof.getPassword());
			statement.setString(6, prof.getRole());
			statement.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se);
		}

		try {

//			String sql = "insert into Professor(profId,designation,department) values (?, ?, ?)";
			String sql=SQLConstants.INSERT_PROFESSOR;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, prof.getId());
			statement.setString(2, prof.getDesignation());
			statement.setString(3, prof.getDepartment());
			int row = statement.executeUpdate();

			System.out.println(row + " professor added");

		} catch (SQLException se) {
			System.out.println(se);
		}

		
	}
	@Override
	public void approveStudent(int studentId) {
		
		statement = null;
		try {
			String sql = SQLConstants.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1,studentId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " student approved.");
			
			
			//logger.info("Student with studentId: " + studentId + " approved by admin.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
		
	}

	@Override
	public ArrayList<Student> viewUnapprovedRegistrations() {
		
		statement = null;
		ArrayList<Student> userList = new ArrayList<Student>();
		try {
			
			String sql = SQLConstants.VIEW_PENDING_ADMISSION_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				// int id, String name, String phone, String email, String password, String branch, String batch
				// "select userId, username, password, phone, email, role, studentId, branch, batch from Student natural join User where isApproved = 0";
				Student user = new Student();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setRole("student");
				user.setEmail(resultSet.getString(5));
				user.setBranch(resultSet.getString(8));
				user.setBatch(resultSet.getString(9));

				userList.add(user);
				
			}
			
			System.out.println(userList.size() + " students have pending-approval.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
		
		return userList;
		
	}

	@Override
	public ArrayList<Professor> viewProfessors() {
		statement = null;
		ArrayList<Professor> professorList = new ArrayList<>();
		try {
			
			String sql = SQLConstants.VIEW_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Professor professor = new Professor();
				professor.setId(resultSet.getInt(1));
				professor.setName(resultSet.getString(2));
				professor.setPassword(resultSet.getString(3));
				professor.setPhone(resultSet.getString(4));
				professor.setRole("professor");
				professor.setEmail(resultSet.getString(5));
				professor.setDepartment(resultSet.getString(8));
				professor.setDesignation(resultSet.getString(9));
				professorList.add(professor);
				
			}
			
			System.out.println(professorList.size() + " professors in the institute.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
		return professorList;
	}
	
	

}