/*
 * Interface: UserDAOInterface
 * Description: Interface for User Data Access Object (DAO) operations.
 * Author: Shivam and Shrey
 */
package com.flipkart.dao;

public interface UserDAOInterface {

    /**
     * Method: changePassword
     * Description: Changes the password of a user.
     * @param userId The ID of the user.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     */
    public void changePassword(int userId, String oldPassword, String newPassword);
}
