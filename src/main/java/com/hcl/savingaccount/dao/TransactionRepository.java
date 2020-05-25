package com.hcl.savingaccount.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.savingaccount.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query(value = "SELECT * FROM transaction WHERE account_id=?1 OR beneficiary_account_id=?1 ORDER BY "
			+ "transaction_date DESC LIMIT 0, 3", nativeQuery = true)
	  Optional<List<Transaction>> findMiniTransactions(long accountId);

}
