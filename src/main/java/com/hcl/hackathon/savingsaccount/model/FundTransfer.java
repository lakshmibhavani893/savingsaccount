package com.hcl.hackathon.savingsaccount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class FundTransfer {
	@Column(name="savingsAccountNumber",nullable=false)
	private long savingsAccountNumber;
	@Column(name="beneficiaryAccountNumber",nullable=false)
	private long beneficiaryAccountNumber;
	@Column(name="transferAmmount",nullable=false)
	private double transferAmmount;
	public FundTransfer(long savingsAccountNumber, long beneficiaryAccountNumber, double transferAmmount) {
		super();
		this.savingsAccountNumber = savingsAccountNumber;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.transferAmmount = transferAmmount;
	}
	public FundTransfer() {
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
