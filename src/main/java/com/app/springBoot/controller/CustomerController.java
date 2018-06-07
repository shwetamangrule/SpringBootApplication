/**
 * 
 */
package com.app.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springBoot.exception.BankNotFoundException;
import com.app.springBoot.pojo.Bank;
import com.app.springBoot.pojo.Customer;
import com.app.springBoot.service.BankService;
import com.app.springBoot.service.CustomerService;
import com.app.springBoot.wrapper.BankCustomerWrapper;

/**
 * @author trainee
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/customer")
	public String returnCustomer() {
		return "Hello Customer";
		
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> createCustomer(@RequestBody BankCustomerWrapper bankCustomerWrapper) throws BankNotFoundException {
		System.out.println(bankCustomerWrapper.toString());
		Customer customer = null;
		 Bank bank = bankService.getBankDetails(bankCustomerWrapper.getBankId());
		// System.out.println(bank.toString());
		 if(bank == null) {
			 return new ResponseEntity<String>("Bank does not exist",HttpStatus.OK);
		 }
		 else {
			  customer = bankCustomerWrapper.getCustomer();
			  customer.setBank(bank);
			  System.out.println(customer.toString());
			  Customer cust = customerService.createCustomer(customer);
			  
			  return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		 }
		 
	
		
	}
	
}
