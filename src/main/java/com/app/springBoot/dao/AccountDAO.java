/**
 * 
 */
package com.app.springBoot.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.app.springBoot.pojo.Account;



/**
 * @author trainee
 *
 */
public interface AccountDAO extends JpaRepository<Account, Integer>{

//	@Query
//	void createAccount(Account account);
//	
	//void getAccountDetails(int accountId);

}
