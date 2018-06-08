package com.app.springBoot.service;



import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Bank;

public interface BankService {
	
	public Bank createBank(Bank bank) throws ExceptionInBank;
	public Bank getBankDetails(long bankId) throws ExceptionInBank;

}
