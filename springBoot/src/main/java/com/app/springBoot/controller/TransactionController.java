/**
 * 
 */
package com.app.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Transaction;
import com.app.springBoot.service.TransactionService;

/**
 * @author trainee
 *
 */
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/generatetransaction/{transactionId}")
	public int generateTransactionReport(@PathVariable int transactionId) throws ExceptionInBank {
		Transaction transaction = transactionService.generateTransactioonReport(transactionId);
		
		if(transaction != null) {
			return 200;
		}else {
			throw new ExceptionInBank("Failed To Get Transaction Id");
		}
		
		
	}
}
