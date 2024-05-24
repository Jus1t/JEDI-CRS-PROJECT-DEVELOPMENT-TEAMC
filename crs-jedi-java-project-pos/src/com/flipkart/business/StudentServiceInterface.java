/*
 * Interface: StudentServiceInterface
 * Description: Interface for Student service operations.
 * Author: Hardik and Shivam
 */
package com.flipkart.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

public interface StudentServiceInterface {

    /**
     * Method: payBills
     * Description: Pays bills for a student.
     * @param id The ID of the student.
     */
    public void payBills(int id);

    /**
     * Method: registerCourse
     * Description: Registers a course for a student.
     * @param studentId The ID of the student.
     * @param courseId The ID of the course.
     * @param semester The semester for which the course is being registered.
     * @return True if course is registered successfully, false otherwise.
     * @throws CourseAlreadyRegisteredException If the course is already registered by the student.
     * @throws CourseLimitExceededException If the course limit is exceeded for the student.
     */
    public boolean registerCourse(int studentId, int courseId, String semester) throws CourseAlreadyRegisteredException, CourseLimitExceededException;

    /**
     * Method: viewResult
     * Description: Views the result of a student.
     * @param id The ID of the student.
     * @return A HashMap containing course IDs and corresponding grades.
     * @throws GradeNotAllotedException If grades are not allotted yet.
     */
    public HashMap<Integer, String> viewResult(int id) throws GradeNotAllotedException;

    /**
     * Method: viewcatalogue
     * Description: Views the course catalogue.
     * @param sid The ID of the student.
     */
    public void viewcatalogue(int sid);

    /**
     * Method: dropCourse
     * Description: Drops a course for a student.
     * @param courseId The ID of the course to be dropped.
     * @param studentId The ID of the student.
     * @return True if course is dropped successfully, false otherwise.
     * @throws SQLException If a SQL exception occurs.
     */
    public boolean dropCourse(int courseId, int studentId) throws SQLException;

    /**
     * Method: viewRegisteredCourses
     * Description: Views registered courses of a student.
     * @param studentId The ID of the student.
     * @return An ArrayList containing registered courses.
     * @throws SQLException If a SQL exception occurs.
     */
    public ArrayList<Course> viewRegisteredCourses(int studentId) throws SQLException;

    /**
     * Method: calculateFee
     * Description: Calculates fee for a student.
     * @param studentId The ID of the student.
     * @return The calculated fee.
     * @throws SQLException If a SQL exception occurs.
     */
    public double calculateFee(int studentId) throws SQLException;

    /**
     * Method: seatAvailable
     * Description: Checks if seat is available for a course.
     * @param courseId The ID of the course.
     * @return True if seat is available, false otherwise.
     * @throws SQLException If a SQL exception occurs.
     */
    public boolean seatAvailable(int courseId) throws SQLException;

    /**
     * Method: isRegistered
     * Description: Checks if a student is registered for a course.
     * @param courseCode The code of the course.
     * @param studentId The ID of the student.
     * @return True if student is registered for the course, false otherwise.
     * @throws SQLException If a SQL exception occurs.
     */
    public boolean isRegistered(int courseCode, int studentId) throws SQLException;

    /**
     * Method: getRegistrationStatus
     * Description: Retrieves registration status of a student.
     * @param studentId The ID of the student.
     * @return True if student is registered, false otherwise.
     * @throws SQLException If a SQL exception occurs.
     */
    public boolean getRegistrationStatus(int studentId) throws SQLException;

    /**
     * Method: viewCourses
     * Description: Views available courses for a student.
     * @param studentId The ID of the student.
     * @return An ArrayList containing available courses.
     * @throws SQLException If a SQL exception occurs.
     */
    public ArrayList<Course> viewCourses(int studentId) throws SQLException;
}
