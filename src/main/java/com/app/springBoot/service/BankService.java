package com.app.springBoot.service;


import com.app.springBoot.exception.BankNotFoundException;
import com.app.springBoot.pojo.Bank;

public interface BankService {
	
	public Bank createBank(Bank bank) throws BankNotFoundException;
	public Bank getBankDetails(long bankId) throws BankNotFoundException;

}
