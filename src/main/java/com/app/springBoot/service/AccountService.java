/**
 * 
 */
package com.app.springBoot.service;



import com.app.springBoot.pojo.Account;

/**
 * @author trainee
 *
 */
public interface AccountService {
	
	public Account createAccount(Account account);
	public Account getAccountDetails(int accountId);
	public int depositMoney(int accountId);
	public int withdrawMoney(int accountId);
	

}
