package com.hcl.savingaccount.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.savingaccount.dao.TransactionRepository;
import com.hcl.savingaccount.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getMiniTransactions(long accountId) {
		List<Transaction> holders = new ArrayList<>();
		holders = transactionRepository.findMiniTransactions(accountId).get();
		return holders;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
