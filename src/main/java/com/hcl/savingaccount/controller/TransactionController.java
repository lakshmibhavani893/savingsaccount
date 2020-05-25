package com.hcl.savingaccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.savingaccount.model.Transaction;
import com.hcl.savingaccount.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(value = "/transaction/{accountId}")
	public ResponseEntity<List<Transaction>> getMiniTransactions(@PathVariable("accountId") long accountId) {
		List<Transaction> transactions=transactionService.getMiniTransactions(accountId);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

}
