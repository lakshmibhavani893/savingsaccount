package com.hcl.savingaccount.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Beneficiary;
import com.hcl.savingaccount.model.Transaction;
import com.hcl.savingaccount.model.Transfer;
import com.hcl.savingaccount.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@GetMapping(value="/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable long id){
		Account account=accountService.findAccountById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	@GetMapping("/account")
	public ResponseEntity<Set<Beneficiary>> getAllBeneficieriesByAccountId(@RequestParam long accountId){
		
		Set<Beneficiary> beneficieries=accountService.getallBeneficiariesByNo(accountId);
		return new ResponseEntity<Set<Beneficiary>>(beneficieries, HttpStatus.OK);
		
	}
	@GetMapping("/account1/{name}")
	public ResponseEntity<Account> getAccountByName(@PathVariable String name){
		Account account=accountService.findByAccountHolderName(name);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	@PostMapping("/transfer")
	public ResponseEntity<Transaction> transfer(@RequestBody Transfer transfer){
	Transaction transaction=accountService.transfer(transfer);
		return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
		
		
	}

}
