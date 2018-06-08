/**
 * 
 */
package com.app.springBoot.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author trainee
 *
 */
@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@Column(name = "amount")
	private BigDecimal amount;
	// private String transcationType;
	@Column(name = "transaction_type")
	private TransactionType transactionType;
	/**
	 * 
	 */
	public Transaction() {
		super();
	}
	/**
	 * @param transactionId
	 * @param customer
	 * @param account
	 * @param amount
	 * @param transactionType
	 */
	public Transaction(int transactionId, Customer customer, Account account, BigDecimal amount,
			TransactionType transactionType) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.account = account;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	
	/**
	 * @param customer
	 * @param account
	 * @param amount
	 * @param transactionType
	 */
	public Transaction(Customer customer, Account account, BigDecimal amount, TransactionType transactionType) {
		super();
		this.customer = customer;
		this.account = account;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", account=" + account
				+ ", amount=" + amount + ", transactionType=" + transactionType + "]";
	}


}