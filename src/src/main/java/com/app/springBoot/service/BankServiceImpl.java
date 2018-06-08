package com.app.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.BankDAO;
import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Bank;


@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDAO bankDAO;

	@Override
	public Bank createBank(Bank bank) throws ExceptionInBank {
		// TODO Auto-generated method stub
		return bankDAO.save(bank);
	}

	@Override
	public Bank getBankDetails(long bankId) throws ExceptionInBank {
		// TODO Auto-generated method stub
		
		Optional<Bank> bankslist = bankDAO.findById(bankId);
		if(bankslist.isPresent()) {
				return bankslist.get();
		}
		else {
			throw new ExceptionInBank("BankId Noy Found");		
		}
		
	}

}
