package com.hcl.savingaccount.service;


import java.util.Set;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Beneficiary;
import com.hcl.savingaccount.model.Transaction;
import com.hcl.savingaccount.model.Transfer;

public interface AccountService {

	public Account findByAccountHolderName(String accountHolderName);
	public Set<Beneficiary> getallBeneficiariesByNo(long accountNumber);
	public Transaction transfer(Transfer fundTransfer);
	public Account findAccountById(long accountId);
	
	
}
