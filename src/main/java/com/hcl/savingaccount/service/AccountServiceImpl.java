package com.hcl.savingaccount.service;

import java.util.Date;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.savingaccount.dao.AccountRepository;
import com.hcl.savingaccount.dao.BeneficiaryRepository;
import com.hcl.savingaccount.exception.AccountNotFoundException;
import com.hcl.savingaccount.exception.BeneficiaryNotFoundException;
import com.hcl.savingaccount.exception.InsufficientFundsException;
import com.hcl.savingaccount.exception.InvalidAccountNumberException;
import com.hcl.savingaccount.exception.InvalidBeneficiaryException;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Beneficiary;
import com.hcl.savingaccount.model.Transaction;
import com.hcl.savingaccount.model.Transfer;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	TransactionService transactionService;

	@Override
	public Account findByAccountHolderName(String accountHolderName) {
		Account account = accountRepository.findByAccountHolderName(accountHolderName);
		if (account != null) {
			return account;
		}
		throw new AccountNotFoundException();
	}

	@Override
	public Set<Beneficiary> getallBeneficiariesByNo(long accountNumber) {
		return accountRepository.getOne(accountNumber).getBenefeciaries();
	}

	@Override
	public Transaction transfer(Transfer fundTransfer) {
		if (fundTransfer.getSavingsAccountNumber() == fundTransfer.getBeneficiaryAccountNumber()) {
			throw new InvalidAccountNumberException();
		}
		Account fromAcc = accountRepository.getAccountByAccountNumber(fundTransfer.getSavingsAccountNumber())
				.orElseThrow(() -> new AccountNotFoundException());
		if (fromAcc.getBalance() < fundTransfer.getTransferAmmount()) {
			throw new InsufficientFundsException();
		}
		fromAcc.setBalance(fromAcc.getBalance() - fundTransfer.getTransferAmmount());
		accountRepository.saveAndFlush(fromAcc);
		Beneficiary toAcc = beneficiaryRepository
				.findByBeneficiaryAccountNumber(fundTransfer.getBeneficiaryAccountNumber())
				.orElseThrow(() -> new BeneficiaryNotFoundException());
		if (fromAcc.getBenefeciaries().contains(toAcc)) {
			toAcc.setBalance(toAcc.getBalance() + fundTransfer.getTransferAmmount());
			beneficiaryRepository.saveAndFlush(toAcc);
		} else {
			throw new InvalidBeneficiaryException();
		}
		Transaction transaction = new Transaction(new Date(), fundTransfer.getTransferAmmount(), fromAcc,
				fundTransfer.getBeneficiaryAccountNumber(), "transaction done successfully");
		transaction = transactionService.createTransaction(transaction);
		return transaction;
	}

	@Override
	public Account findAccountById(long accountId) {
		return accountRepository.getOne(accountId);
	}

}
