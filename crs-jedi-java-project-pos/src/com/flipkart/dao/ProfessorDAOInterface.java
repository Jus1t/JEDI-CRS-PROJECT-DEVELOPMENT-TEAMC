/*
 * Interface: ProfessorDAOInterface
 * Description: Interface for Professor Data Access Object (DAO) operations.
 * Author: Yashwant and Shrey
 */
package com.flipkart.dao;

import java.util.ArrayList;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

public interface ProfessorDAOInterface {

    /**
     * Method: selectCourse
     * Description: Selects a course to teach for a professor.
     * @param profId The ID of the professor.
     * @param courseId The ID of the course.
     */
    public void selectCourse(int profId, int courseId);

    /**
     * Method: submitGrade
     * Description: Submits grade for a student in a course.
     * @param studentId The ID of the student.
     * @param courseId The ID of the course.
     * @param grade The grade to be submitted.
     */
    public void submitGrade(int studentId, int courseId, String grade);

    /**
     * Method: getCoursesByProfessor
     * Description: Retrieves courses taught by a professor.
     * @param profId The ID of the professor.
     * @return An ArrayList containing courses taught by the professor.
     */
    public ArrayList<Course> getCoursesByProfessor(int profId);

    /**
     * Method: getEnrolledStudents
     * Description: Retrieves enrolled students for courses taught by a professor.
     * @param profId The ID of the professor.
     * @return An ArrayList containing enrolled students for courses taught by the professor.
     */
    public ArrayList<EnrolledStudent> getEnrolledStudents(int profId);
}
