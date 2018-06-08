/**
 * 
 */
package com.app.springBoot.service;



import java.math.BigDecimal;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Account;
import com.app.springBoot.wrapper.BankCustomerAccountWrapper;

/**
 * @author trainee
 *
 */
public interface AccountService {
	
	public Account createAccount(BankCustomerAccountWrapper bankCustomerAccountWrapper) throws ExceptionInBank ;
	public Account getAccountDetails(int accountId) throws ExceptionInBank;
	public Account depositMoney(int accountId, BigDecimal amount) throws ExceptionInBank;
	public Account withdrawMoney(int accountId, BigDecimal amount) throws ExceptionInBank;
	

}
