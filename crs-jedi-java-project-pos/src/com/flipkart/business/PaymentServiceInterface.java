/*
 * Interface: PaymentServiceInterface
 * Description: Interface for Payment service operations.
 * Author: Shrey and Yashwant
 */
package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentFailedException;

public interface PaymentServiceInterface {

    /**
     * Method: confirmPayment
     * Description: Confirms the payment.
     * @return True if payment is confirmed successfully, false otherwise.
     */
    public boolean confirmPayment();

    /**
     * Method: getReceipt
     * Description: Retrieves the payment receipt.
     * @return The payment receipt.
     */
    public Payment getReceipt();

    /**
     * Method: cancelPayment
     * Description: Cancels the payment.
     * @return True if payment is canceled successfully, false otherwise.
     */
    public boolean cancelPayment();

    /**
     * Method: onlinePayment
     * Description: Processes online payment.
     * @param studentId The ID of the student making the payment.
     * @param amount The amount to be paid.
     * @param bankName The name of the bank.
     * @param bankHolderName The name of the bank holder.
     * @param accountNo The account number.
     * @param ifsc The IFSC code.
     * @return True if payment is successful, false otherwise.
     * @throws PaymentFailedException If payment fails.
     */
    public boolean onlinePayment(int studentId, double amount, String bankName, String bankHolderName, String accountNo, String ifsc) throws PaymentFailedException;
}
