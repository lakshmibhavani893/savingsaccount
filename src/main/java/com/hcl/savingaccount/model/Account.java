package com.hcl.savingaccount.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	private double balance;
	@Column(name="accountHolderName")
	private String accountHolderName;
	@Temporal(TemporalType.DATE)
    @Column(name = "openingDate")
	private Date openingDate;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<Beneficiary> benefeciaries;
	public Account() {
		super();
	}
	public Account(double balance, String accountHolderName, Date openingDate, Customer customer, Set<Beneficiary> benefeciaries) {
		super();
		this.balance = balance;
		this.accountHolderName = accountHolderName;
		this.openingDate = openingDate;
		this.customer = customer;
		this.benefeciaries = benefeciaries;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Beneficiary> getBenefeciaries() {
		return benefeciaries;
	}
	public void setBenefeciaries(Set<Beneficiary> benefeciaries) {
		this.benefeciaries = benefeciaries;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", accountHolderName=" + accountHolderName + ", openingDate="
				+ openingDate + ", customer=" + customer + ", benefeciaries=" + benefeciaries + "]";
	}
	

}
