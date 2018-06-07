/**
 * 
 */
package com.app.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.CustomerDAO;
import com.app.springBoot.pojo.Customer;

/**
 * @author trainee
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer.toString());
		return customerDAO.save(customer);
	}

	@Override
	public Customer getCustomerDetails(int customerId) {
		// TODO Auto-generated method stub
		 Optional<Customer> customerlist = customerDAO.findById(customerId);
		return customerlist.get();

	}

}
