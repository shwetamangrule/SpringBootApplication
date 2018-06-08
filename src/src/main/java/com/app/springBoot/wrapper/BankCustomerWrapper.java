/**
 * 
 */
package com.app.springBoot.wrapper;

import com.app.springBoot.pojo.Customer;

/**
 * @author trainee
 *
 */
public class BankCustomerWrapper {
	 private Customer customer;
	 private long bankId;
	 
	 
	/**
	 * 
	 */
	public BankCustomerWrapper() {
		super();
	}

	/**
	 * @param customer
	 * @param bankId
	 */
	public BankCustomerWrapper(Customer customer, long bankId) {
		super();
		this.customer = customer;
		this.bankId = bankId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the bankId
	 */
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankCustomerWrapper [customer=" + customer + ", bankId=" + bankId + "]";
	}
	 
	 
	

}
