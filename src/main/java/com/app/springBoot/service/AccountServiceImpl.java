/**
 * 
 */
package com.app.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.AccountDAO;
import com.app.springBoot.pojo.Account;

/**
 * @author trainee
 *
 */

@Service
public class AccountServiceImpl implements AccountService{
	
//	@Autowired
//	private AccountDAO accountDAO;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountDetails(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int depositMoney(int accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdrawMoney(int accountId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
