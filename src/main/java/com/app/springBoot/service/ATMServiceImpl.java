/**
 * 
 */
package com.app.springBoot.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.ATMDAO;
import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.ATM;
import com.app.springBoot.pojo.Bank;
import com.app.springBoot.wrapper.BankATMWrapper;

/**
 * @author trainee
 *
 */
@Service
public class ATMServiceImpl implements ATMService {
	
	@Autowired
	private ATMDAO atmDAO;
	
	@Autowired
	private BankService bankService;
	
	Logger logger = LoggerFactory.getLogger(ATMServiceImpl.class);
	
	@Override
	public ATM createATM(BankATMWrapper bankATMWrapper) throws ExceptionInBank {
		// TODO Auto-generated method stub
		System.out.println(bankATMWrapper.toString());
		Bank bank = bankService.getBankDetails(bankATMWrapper.getBankId());
		if(bank != null) {
			ATM atm = bankATMWrapper.getAtm();
			 atm.setBank(bank);
			 System.out.println(atm.toString());
			 return atmDAO.save(atm);
		}else {
			throw new ExceptionInBank("Bank does not exist");	
		}
		
	}
	
	@Override
	public String addMoneyFromBank(int atmId, BigDecimal amount) throws ExceptionInBank {
		// TODO Auto-generated method stub
		ATM atm = this.getATMDetails(atmId);
		if(atm != null) {
			Bank bank = atm.getBank();
			if(amount.compareTo(BigDecimal.ZERO) > 0){
				if(amount.compareTo(bank.getAmount()) == -1){
					atm.setAmount(atm.getAmount().add(amount));
					bank.setAmount(bank.getAmount().subtract(amount));
					atmDAO.save(atm);
					return "Amount is added to bank";
				}else {
					logger.error("Insufficient Amount");
					throw new ExceptionInBank("This Amount Exceeds The Available Bank Balance");
				}
			}else {
				logger.error("Ivalid Amount: Should be greater than 0");
				throw new ExceptionInBank("Ivalid Amount: Should be greater than 0");
			}
		}else {
			logger.error("Error in Creating ATM");
			throw new ExceptionInBank("ATM Does Not Exist");
		}
	}

	@Override
	public String withdrawMoney(int atmId) throws ExceptionInBank {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ATM getATMDetails(int atmId) throws ExceptionInBank {
		// TODO Auto-generated method stub
		Optional<ATM> atmList = atmDAO.findById(atmId);
		if(atmList.isPresent()) {
			return atmList.get();
		}else {
			throw new ExceptionInBank("ATM_ID NOT FOUND");
		}
	}

}
