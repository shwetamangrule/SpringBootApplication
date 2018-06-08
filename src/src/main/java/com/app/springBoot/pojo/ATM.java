/**
 * 
 */
package com.app.springBoot.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author trainee
 *
 */
@Entity
@Table(name = "ATM")
public class ATM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atm_id")
	private int ATMId;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
}

