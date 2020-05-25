package com.hcl.savingaccount.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long beneficiaryAccountNumber;
	private String name;
	private double balance;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountNumber")
	@JsonIgnore
	private Account account;
	public Beneficiary() {
		super();
	}
	public Beneficiary(String name, double balance, Date date, Account account) {
		super();
		this.name = name;
		this.balance = balance;
		this.date = date;
		this.account = account;
	}
	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Beneficiary [beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", name=" + name + ", balance="
				+ balance + ", date=" + date + ", account=" + account + "]";
	}
	
	

}
