/**
 * 
 */
package com.app.springBoot.wrapper;

import com.app.springBoot.pojo.ATM;

/**
 * @author trainee
 *
 */
public class BankATMWrapper {
	
	private ATM atm;
	private long bankId;
	/**
	 * 
	 */
	public BankATMWrapper() {
		super();
	}
	/**
	 * @param atm
	 * @param bankId
	 */
	public BankATMWrapper(ATM atm, long bankId) {
		super();
		this.atm = atm;
		this.bankId = bankId;
	}
	/**
	 * @return the atm
	 */
	public ATM getAtm() {
		return atm;
	}
	/**
	 * @param atm the atm to set
	 */
	public void setAtm(ATM atm) {
		this.atm = atm;
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
		return "BankATMWrapper [atm=" + atm + ", bankId=" + bankId + "]";
	}

}
