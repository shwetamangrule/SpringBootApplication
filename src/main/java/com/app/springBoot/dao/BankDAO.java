package com.app.springBoot.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springBoot.pojo.Bank;


@Repository
public interface BankDAO extends JpaRepository<Bank, Long> {

//	void createBank(Bank bank);
//	void showBankDetails(long bankId);
//	
//	

}
