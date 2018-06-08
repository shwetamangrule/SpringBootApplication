/**
 * 
 */
package com.app.springBoot.service;


import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Customer;
import com.app.springBoot.wrapper.BankCustomerWrapper;

/**
 * @author trainee
 *
 */
public interface CustomerService {
	public Customer createCustomer(BankCustomerWrapper bankCustomerWrapper) throws ExceptionInBank;
	public Customer getCustomerDetails(int customerId) throws ExceptionInBank;

}
