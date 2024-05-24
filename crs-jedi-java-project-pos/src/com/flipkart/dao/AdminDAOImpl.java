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

			String sql = "select courseId, courseName, instructorId from Course";
			statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Course course = new Course();
				course.setCourseID(resultSet.getInt(1));
				course.setCourseName(resultSet.getString(2));
				course.setInstructorID(resultSet.getInt(3));
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

			String sql = "insert into Course(courseId, courseName, instructorId, enrolledStudents, isOffered) values (?, ?, ?, ?, ?)";
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

			String sql = "delete from Course where courseId = ?";
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

			String sql = "update Course set isOffered=false where courseId = ?";
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

			String sql = "update Course set instructorId=? where courseId = ?";
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

			String sql = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
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

			String sql = "insert into Student(studentId,branch,batch) values (?, ?, ?)";
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

			String sql = "select * from User where userId=? AND password=?";
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

			String sql = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
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

			String sql = "insert into Professor(profId,designation,department) values (?, ?, ?)";
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
	
	

}