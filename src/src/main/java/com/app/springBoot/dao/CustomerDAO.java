/**
 * 
 */
package com.app.springBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springBoot.pojo.Customer;

/**
 * @author trainee
 *
 */

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	
	//void createCustomer(Customer customer);

}
