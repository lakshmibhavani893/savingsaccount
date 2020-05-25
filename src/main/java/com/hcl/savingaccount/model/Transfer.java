package com.hcl.savingaccount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Transfer {
	@Id
	@Column(name="savingsAccountNumber",nullable=false)
	private long savingsAccountNumber;
	@Column(name="beneficiaryAccountNumber",nullable=false)
	private long beneficiaryAccountNumber;
	@Column(name="transferAmmount",nullable=false)
	private double transferAmmount;
	public Transfer(long savingsAccountNumber, long beneficiaryAccountNumber, double transferAmmount) {
		super();
		this.savingsAccountNumber = savingsAccountNumber;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.transferAmmount = transferAmmount;
	}
	public Transfer() {
		super();
	}
	public long getSavingsAccountNumber() {
		return savingsAccountNumber;
	}
	public void setSavingsAccountNumber(long savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}
	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public double getTransferAmmount() {
		return transferAmmount;
	}
	public void setTransferAmmount(double transferAmmount) {
		this.transferAmmount = transferAmmount;
	}
	@Override
	public String toString() {
		return "FundTransfer [savingsAccountNumber=" + savingsAccountNumber + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + ", transferAmmount=" + transferAmmount + "]";
	}
	

}
