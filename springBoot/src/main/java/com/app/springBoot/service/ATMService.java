/**
 * 
 */
package com.app.springBoot.service;

import java.math.BigDecimal;

import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.ATM;
import com.app.springBoot.wrapper.BankATMWrapper;

/**
 * @author trainee
 *
 */
public interface ATMService {
	public ATM createATM(BankATMWrapper bankATMWrapper) throws ExceptionInBank;
	
	public String addMoneyFromBank(int atmId, BigDecimal amount) throws ExceptionInBank;
	
	public String withdrawMoney(int atmId) throws ExceptionInBank;
	
	public ATM getATMDetails(int atmId) throws ExceptionInBank;
	
	

}
