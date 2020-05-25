package com.hcl.savingaccount.dao;



import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Beneficiary;


public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Account findByAccountHolderName(String accountHolderName);
	public Set<Beneficiary> findByAccountNumber(long number);
	public Optional<Account> getAccountByAccountNumber(long accountId);

}
