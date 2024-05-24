/*
 * Interface: AdminDAOInterface
 * Description: Interface for Admin Data Access Object (DAO) operations.
 * Author: Shivam and Hardik
 */
package com.flipkart.dao;

import java.util.ArrayList;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.AuthenticationException;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotFoundException;

public interface AdminDAOInterface {

    /**
     * Method: addCourse
     * Description: Adds a course.
     * @param course The course object to be added.
     * @throws CourseExistsAlreadyException If the course already exists.
     */
    public void addCourse(Course course) throws CourseExistsAlreadyException;

    /**
     * Method: deleteCourse
     * Description: Deletes a course.
     * @param id The ID of the course to be deleted.
     * @throws CourseNotFoundException If the course does not exist.
     */
    public void deleteCourse(int id) throws CourseNotFoundException;

    /**
     * Method: showCourses
     * Description: Retrieves all courses.
     * @return An ArrayList containing all courses.
     */
    public ArrayList<Course> showCourses();

    /**
     * Method: closeRegistration
     * Description: Closes registration for a course.
     * @param id The ID of the course for which registration is to be closed.
     */
    public void closeRegistration(int id);

    /**
     * Method: assignCourse
     * Description: Assigns a course to an instructor.
     * @param courseId The ID of the course.
     * @param instructorId The ID of the instructor.
     */
    public void assignCourse(int courseId, int instructorId);

    /**
     * Method: registerStudent
     * Description: Registers a student.
     * @param student The student object to be registered.
     */
    public void registerStudent(Student student);

    /**
     * Method: verifyCredentials
     * Description: Verifies login credentials.
     * @param id The ID of the user.
     * @param password The password of the user.
     * @return The role of the user if authentication is successful.
     * @throws AuthenticationException If authentication fails.
     */
    public String verifyCredentials(int id, String password) throws AuthenticationException;

    /**
     * Method: registerProfessor
     * Description: Registers a professor.
     * @param prof The professor object to be registered.
     */
    public void registerProfessor(Professor prof);

    /**
     * Method: approveStudent
     * Description: Approves a student registration.
     * @param studentId The ID of the student to be approved.
     */
    public void approveStudent(int studentId);

    /**
     * Method: viewUnapprovedRegistrations
     * Description: Retrieves unapproved student registrations.
     * @return An ArrayList containing unapproved student registrations.
     */
    public ArrayList<Student> viewUnapprovedRegistrations();

    /**
     * Method: viewProfessors
     * Description: Retrieves all registered professors.
     * @return An ArrayList containing all registered professors.
     */
    public ArrayList<Professor> viewProfessors();

    /**
     * Method: approveCourse
     * Description: Approves a course registration for a student.
     * @param courseId The ID of the course to be approved.
     * @param studentId The ID of the student for whom the course is to be approved.
     */
    public void approveCourse(int courseId, int studentId);
}
