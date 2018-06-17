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
@Table(name = "ATM")
public class ATM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atm_id")
	private int ATMId;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	/**
	 * 
	 */
	public ATM() {
		super();
	}

	/**
	 * @param aTMId
	 * @param amount
	 * @param bank
	 */
	public ATM(int aTMId, BigDecimal amount, Bank bank) {
		super();
		ATMId = aTMId;
		this.amount = amount;
		this.bank = bank;
	}

	/**
	 * @return the aTMId
	 */
	public int getATMId() {
		return ATMId;
	}

	/**
	 * @param aTMId the aTMId to set
	 */
	public void setATMId(int aTMId) {
		ATMId = aTMId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATM [ATMId=" + ATMId + ", amount=" + amount + ", bank=" + bank + "]";
	}
}


