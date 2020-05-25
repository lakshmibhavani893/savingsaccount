package com.hcl.savingaccount.service;

import java.util.List;


import com.hcl.savingaccount.model.Transaction;



public interface TransactionService {
	
	public List<Transaction> getMiniTransactions(long accountId);
	public Transaction createTransaction(Transaction transaction);

}
