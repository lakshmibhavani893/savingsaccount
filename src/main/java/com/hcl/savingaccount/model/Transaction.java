package com.hcl.savingaccount.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Column
	private Date transactionDate;
	@Column
	private double transactionamount;
	@ManyToOne(optional = false)
	@JoinColumn(name = "accountId")
	private Account account;
	@Column
	private long beneficiaryAccountId;
	@Column
	private String txnMsg;

	
	public Transaction() {
		
	}

	public Transaction(Date transactionDate, double transactionamount, Account account, String txnMsg) {
		super();
		this.transactionDate = transactionDate;
		this.transactionamount = transactionamount;
		this.account = account;
		this.txnMsg = txnMsg;
	}

	public Transaction(Date transactionDate, double transactionamount, Account account, long l,
			String txnMsg) {
		super();
		this.transactionDate = transactionDate;
		this.transactionamount = transactionamount;
		this.account = account;
		this.beneficiaryAccountId = l;
		this.txnMsg = txnMsg;
	}

	

	public String getTxnMsg() {
		return txnMsg;
	}

	public void setTxnMsg(String txnMsg) {
		this.txnMsg = txnMsg;
	}

	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getbeneficiaryAccountId() {
		return beneficiaryAccountId;
	}

	public void setDestAccountId(int beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
	}

}
