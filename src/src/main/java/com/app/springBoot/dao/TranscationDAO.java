package com.app.springBoot.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springBoot.pojo.Bank;
import com.app.springBoot.pojo.Transaction;


@Repository
public interface TranscationDAO extends JpaRepository<Transaction, Integer> {

//	void createBank(Bank bank);
//	void showBankDetails(long bankId);
//	
//	

}
