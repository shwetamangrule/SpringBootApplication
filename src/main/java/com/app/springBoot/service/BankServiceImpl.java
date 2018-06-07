package com.app.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.BankDAO;
import com.app.springBoot.exception.BankNotFoundException;
import com.app.springBoot.pojo.Bank;


@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDAO bankDAO;

	@Override
	public Bank createBank(Bank bank) throws BankNotFoundException {
		// TODO Auto-generated method stub
		return bankDAO.save(bank);
	}

	@Override
	public Bank getBankDetails(long bankId) throws BankNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Bank> bankslist = bankDAO.findById(bankId);
		if(bankslist.isPresent()) {
				return bankslist.get();
		}
		else {
			throw new BankNotFoundException("Bank creation failed");		
		}
		
	}

}
