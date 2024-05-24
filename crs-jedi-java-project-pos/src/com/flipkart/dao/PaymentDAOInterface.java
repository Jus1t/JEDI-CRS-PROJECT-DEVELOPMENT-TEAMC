/*
 * Interface: PaymentDAOInterface
 * Description: Interface for Payment Data Access Object (DAO) operations.
 * Author: Shrey and Yashwant
 */
package com.flipkart.dao;

import com.flipkart.exception.PaymentFailedException;

public interface PaymentDAOInterface {

    /**
     * Method: onlinePayment
     * Description: Processes online payment.
     * @param paymentId The ID of the payment.
     * @param studentId The ID of the student making the payment.
     * @param amount The amount to be paid.
     * @param bankName The name of the bank.
     * @param bankHolderName The name of the bank holder.
     * @param accountNo The account number.
     * @param ifsc The IFSC code.
     * @return True if payment is successful, false otherwise.
     * @throws PaymentFailedException If payment fails.
     */
    public boolean onlinePayment(int paymentId, int studentId, double amount, String bankName, String bankHolderName, String accountNo, String ifsc) throws PaymentFailedException;
}
