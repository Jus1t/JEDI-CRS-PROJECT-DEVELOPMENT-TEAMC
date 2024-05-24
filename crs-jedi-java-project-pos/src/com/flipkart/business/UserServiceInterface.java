/*
 * Interface: UserServiceInterface
 * Description: Interface for User service operations.
 * Author: Shivam and Shrey
 */
package com.flipkart.business;

public interface UserServiceInterface {

    /**
     * Method: getRole
     * Description: Retrieves the role of a user.
     * @param userId The ID of the user.
     * @return The role of the user.
     */
    public String getRole(String userId);

    /**
     * Method: updatePassword
     * Description: Updates the password of a user.
     * @param userId The ID of the user.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     */
    public void updatePassword(int userId, String oldPassword, String newPassword);
}
