/**
 * 
 */
package com.app.springBoot.service;

import com.app.springBoot.pojo.Customer;

/**
 * @author trainee
 *
 */
public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public Customer getCustomerDetails(int customerId);

}
