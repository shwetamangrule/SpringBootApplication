/**
 * 
 */
package com.app.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Bank;
import com.app.springBoot.service.BankService;

/**
 * @author trainee
 *
 */
@RestController
//@RequestMapping("/api")
public class BankContoller {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/bank")
	public String returnBank() {
		return "Hello World";
	}
	
	@PostMapping("/addbank")
	public int createBank(@RequestBody Bank bank) throws ExceptionInBank {
		bankService.createBank(bank);
		return 200;
	}

	
}
	