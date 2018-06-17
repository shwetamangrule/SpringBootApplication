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
import com.app.springBoot.pojo.ATM;
import com.app.springBoot.service.ATMService;
import com.app.springBoot.wrapper.BankATMWrapper;

/**
 * @author trainee
 *
 */
@RestController
public class ATMController {
	
	@Autowired
	private ATMService atmService;

	@GetMapping("/atm")
	public String returnATM() {
		return "Hello ATM" ;
		
	}
	
	@PostMapping("/addatm")
	public int createATM(@RequestBody BankATMWrapper bankATMWrapper) throws ExceptionInBank {
		ATM atm = atmService.createATM(bankATMWrapper);
		if(atm != null) {
		return 200;
		}else {
			throw new ExceptionInBank("ATM creation failed");
		}
		
	}
	
	
	
}
