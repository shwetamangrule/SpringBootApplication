/**
 * 
 */
package com.app.springBoot.service;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Transaction;

/**
 * @author trainee
 *
 */


public interface TransactionService {
	public Transaction createTransaction(Transaction transaction);
	
	public Transaction generateTransactioonReport(int transactionId) throws ExceptionInBank;

}
