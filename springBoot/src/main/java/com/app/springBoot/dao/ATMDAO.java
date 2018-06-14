/**
 * 
 */
package com.app.springBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springBoot.pojo.ATM;

/**
 * @author trainee
 *
 */
@Repository
public interface ATMDAO extends JpaRepository<ATM, Integer> {

}
