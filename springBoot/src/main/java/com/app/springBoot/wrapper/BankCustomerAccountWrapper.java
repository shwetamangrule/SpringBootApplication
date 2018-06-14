/**
 * 
 */
package com.app.springBoot.wrapper;

import com.app.springBoot.pojo.Account;

/**
 * @author trainee
 *
 */
public class BankCustomerAccountWrapper {
	
	private long bankId;
	private int customerId;
	private Account account;
	/**
	 * 
	 */
	public BankCustomerAccountWrapper() {
		super();
	}
	/**
	 * @param bankId
	 * @param customerId
	 * @param account
	 */
	public BankCustomerAccountWrapper(long bankId, int customerId, Account account) {
		super();
		this.bankId = bankId;
		this.customerId = customerId;
		this.account = account;
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
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankCustomerAccountWrapper [bankId=" + bankId + ", customerId=" + customerId + ", account=" + account
				+ "]";
	}

	
}
