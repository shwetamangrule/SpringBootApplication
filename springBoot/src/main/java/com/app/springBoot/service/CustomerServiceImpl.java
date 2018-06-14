/**
 * 
 */
package com.app.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.CustomerDAO;
import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Bank;
import com.app.springBoot.pojo.Customer;
import com.app.springBoot.wrapper.BankCustomerWrapper;

/**
 * @author trainee
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private BankService bankService;

	@Override
	public Customer createCustomer(BankCustomerWrapper bankCustomerWrapper) throws ExceptionInBank {
		// TODO Auto-generated method stub
		//System.out.println(customer.toString());
		System.out.println(bankCustomerWrapper.toString());
		Customer customer = null;
		 Bank bank = bankService.getBankDetails(bankCustomerWrapper.getBankId());
		// System.out.println(bank.toString());
		 if(bank != null) {
			 customer = bankCustomerWrapper.getCustomer();
			  customer.setBank(bank);
			  System.out.println(customer.toString());
			  return customerDAO.save(customer);	 
		 }else {
			 throw new ExceptionInBank("Bank does not exist");
		 }
	}

	@Override
	public Customer getCustomerDetails(int customerId) throws ExceptionInBank{
		// TODO Auto-generated method stub
		 Optional<Customer> customerlist = customerDAO.findById(customerId);
		 
		 if(customerlist.isPresent()) {
			 return customerlist.get(); 
		 }
		 else {
			 throw new ExceptionInBank("CustomerID Not Found"); 
		 }
	}
}
