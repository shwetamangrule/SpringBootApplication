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
@Table(name = "account" )

public class Account {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="account_id")
		private int accountId;
		
		@Column(name = "amount")
		private BigDecimal amount;
		
		@ManyToOne
		@JoinColumn(name = "bank_id", nullable = false)
		private Bank bank;
		
		@ManyToOne
		@JoinColumn(name = "customer_id", nullable = false)
		private Customer customer;
		/**
		 * 
		 */
		public Account() {
			super();
		}
		/**
		 * @param accountId
		 * @param amount
		 * @param bank
		 * @param customer
		 */
		public Account(int accountId, BigDecimal amount, Bank bank, Customer customer) {
			super();
			this.accountId = accountId;
			this.amount = amount;
			this.bank = bank;
			this.customer = customer;
		}
		/**
		 * @return the accountId
		 */
		public int getAccountId() {
			return accountId;
		}
		/**
		 * @param accountId the accountId to set
		 */
		public void setAccountId(int accountId) {
			this.accountId = accountId;
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
		 * @return the bank
		 */
		public Bank getBank() {
			return bank;
		}
		/**
		 * @param bank the bank to set
		 */
		public void setBank(Bank bank) {
			this.bank = bank;
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
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", amount=" + amount + ", bank=" + bank + ", customer=" + customer
					+ "]";
		}
		
		
		


}
