/**
 * 
 */
package com.app.springBoot.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Account;
import com.app.springBoot.service.AccountService;
import com.app.springBoot.wrapper.BankCustomerAccountWrapper;

/**
 * @author trainee
 *
 */
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public String returnAccount() {
		return "This is Account";
		
	}
	
	@PostMapping("/addaccount")
	public int createAccount(@RequestBody BankCustomerAccountWrapper bankCustomerAccountWrapper) throws ExceptionInBank {
		//accountService.createAccount(bankCustomerAccountWrapper);
		Account account = accountService.createAccount(bankCustomerAccountWrapper);
		if(account != null) {
			return 200;
		}else {
			throw new ExceptionInBank("Account Creation Failed");
		}
	}
		@GetMapping("/depositmoney/{accountId}/{amount}")
		public int depositMoney(@PathVariable int accountId, @PathVariable BigDecimal amount) throws ExceptionInBank {
			Account account = accountService.depositMoney(accountId, amount);
			if(account != null) {
				return 200;
			}else {
				throw new ExceptionInBank("Failed to Deposit Money");
			}
}
		@GetMapping("/withdrawmoney/{accountId}/{amount}")
		public int withdrawMoney(@PathVariable int accountId, @PathVariable BigDecimal amount) throws ExceptionInBank {
			Account account = accountService.withdrawMoney(accountId, amount);
			if(account != null) {
				return 200;
			}
			throw new ExceptionInBank("Failed to Withdraw Money");
		}
}
