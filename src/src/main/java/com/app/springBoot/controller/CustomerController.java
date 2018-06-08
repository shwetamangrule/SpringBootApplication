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

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Customer;
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
		
	@GetMapping("/customer")
	public String returnCustomer() {
		return "Hello Customer";
		
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> createCustomer(@RequestBody BankCustomerWrapper bankCustomerWrapper) throws ExceptionInBank {
		Customer customer = customerService.createCustomer(bankCustomerWrapper);
		if(customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		else {
			throw new ExceptionInBank("Customer creation failed");
		}
	}
	
	
}
