/**
 * 
 */
package com.app.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springBoot.dao.TransactionDAO;
import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Transaction;

/**
 * @author trainee
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
	//Transaction tr=new Transaction(transaction.getTransactionId(),transaction.getCustomer().getCustomerId(),transaction.getAccount().getAccountId(),transaction.getAmount(),transaction.getTransactionType().deposit)
		return transactionDAO.save(transaction);
		 
	}

	@Override
	public Transaction generateTransactioonReport(int transactionId) throws ExceptionInBank {
		// TODO Auto-generated method stub
		Optional<Transaction> transactionList = transactionDAO.findById(transactionId);
		if(transactionList.isPresent()) {
			return transactionList.get();
		}else {
			throw new ExceptionInBank("TransactionID Not Found");
		}
		
	}

}
