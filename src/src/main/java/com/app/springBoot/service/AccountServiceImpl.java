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

import com.app.springBoot.dao.AccountDAO;
import com.app.springBoot.dao.BankDAO;
import com.app.springBoot.dao.TranscationDAO;
import com.app.springBoot.exception.ExceptionInBank;
import com.app.springBoot.pojo.Account;
import com.app.springBoot.pojo.Bank;
import com.app.springBoot.pojo.Customer;
import com.app.springBoot.pojo.Transaction;
import com.app.springBoot.pojo.TransactionType;
import com.app.springBoot.wrapper.BankCustomerAccountWrapper;

/**
 * @author trainee
 *
 */

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private BankDAO bankDAO;

	@Autowired
	private BankService bankService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TranscationDAO transactionDao;

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public Account createAccount(BankCustomerAccountWrapper bankCustomerAccountWrapper) throws ExceptionInBank {
		// TODO Auto-generated method stub
		// Account account = null;
		Customer customer = customerService.getCustomerDetails(bankCustomerAccountWrapper.getCustomerId());
		if (customer != null) {
			Bank bank = bankService.getBankDetails(customer.getBank().getBankId());
			Account account = bankCustomerAccountWrapper.getAccount();
			account.setCustomer(customer);
			account.setBank(bank);
			return accountDAO.save(account);
		} else {
			throw new ExceptionInBank("CustomerId Not Found So Account Creation Failed");
		}
	}

	@Override
	public Account getAccountDetails(int accountId) throws ExceptionInBank {
		Optional<Account> accountList = accountDAO.findById(accountId);
		if (accountList.isPresent()) {
			return accountList.get();
		} else {
			throw new ExceptionInBank("ACCOUNT_ID NOT FOUND");
		}
	}

	@Override
	public Account depositMoney(int accountId, BigDecimal amount) throws ExceptionInBank {
		// TODO Auto-generated method stub
		Account account = this.getAccountDetails(accountId);
		if (account != null) {
			if (amount.compareTo(BigDecimal.ZERO) > 0) {
				account.setAmount(account.getAmount().add(amount));
				Bank bank = account.getBank();
				bank.setAmount(bank.getAmount().add(amount));
				bankDAO.save(bank);
				Customer customerId = account.getCustomer();
				TransactionType choice = TransactionType.deposit;
				Transaction tr = new Transaction(customerId, account, amount, choice);
				transactionDao.save(tr);
				return accountDAO.save(account);
			} else {
				logger.error("Invalid Amount");
				throw new ExceptionInBank("Amount should be greater than 0");
			}
		} else {
			throw new ExceptionInBank("Account Does Not Exist");
		}

	}

	@Override
	public Account withdrawMoney(int accountId, BigDecimal amount) throws ExceptionInBank {
		Account account = this.getAccountDetails(accountId);
		if (account != null) {
			if (amount.compareTo(BigDecimal.ZERO) > 0) {
				if (amount.compareTo(account.getAmount()) == -1) {
					account.setAmount(account.getAmount().subtract(amount));
					Bank bank = account.getBank();
					bank.setAmount(bank.getAmount().subtract(amount));
					bankDAO.save(bank);
					logger.info("Amount withdrawed");
					return accountDAO.save(account);

				} else {
					logger.error("Insufficient Amount");
					throw new ExceptionInBank("This Amount Exceeds The Actual Account Balance");
				}
			} else {
				throw new ExceptionInBank("Invalid Amount! Please try again");
			}

		} else {
			throw new ExceptionInBank("Account Does not Exist");
		}
	}
}
