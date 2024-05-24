/*
 * Interface: RegistrationServiceInterface
 * Description: Interface for Registration service operations.
 * Author: Saikat and Shrey
 */
package com.flipkart.business;

public interface RegistrationServiceInterface {

    /**
     * Method: addCourse
     * Description: Adds a course for registration.
     * @param courseId The ID of the course to be added.
     * @return True if course is added successfully, false otherwise.
     */
    public boolean addCourse(int courseId);

    /**
     * Method: dropCourse
     * Description: Drops a course from registration.
     * @param courseId The ID of the course to be dropped.
     * @return True if course is dropped successfully, false otherwise.
     */
    public boolean dropCourse(int courseId);

    /**
     * Method: calculateFee
     * Description: Calculates the fee for a student.
     * @param studentId The ID of the student.
     * @return The calculated fee.
     */
    public double calculateFee(int studentId);

    /**
     * Method: viewGradeCard
     * Description: Views the grade card of a student.
     * @param studentId The ID of the student.
     */
    public void viewGradeCard(int studentId);

    /**
     * Method: viewCourses
     * Description: Views available courses.
     * @param studentId The ID of the student.
     */
    public void viewCourses(int studentId);

    /**
     * Method: viewRegisteredCourses
     * Description: Views registered courses of a student.
     * @param studentId The ID of the student.
     */
    public void viewRegisteredCourses(int studentId);

    /**
     * Method: getRegistrationStatus
     * Description: Retrieves registration status of a student.
     * @param studentId The ID of the student.
     * @return True if student is registered, false otherwise.
     */
    public boolean getRegistrationStatus(int studentId);

    /**
     * Method: setRegistrationStatus
     * Description: Sets registration status of a student.
     * @param studentId The ID of the student.
     */
    public void setRegistrationStatus(int studentId);
}
