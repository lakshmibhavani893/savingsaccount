package com.hcl.savingaccount.service;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.savingaccount.dao.AccountRepository;
import com.hcl.savingaccount.exception.AccountNotFoundException;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Beneficiary;
@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	@Mock
	AccountRepository accountRepository; 
	static Account account=null;
	@BeforeClass
	public static void setUp() {
		account = new Account();

	}
	@Before
	public void beforeMethod(){
		account.setAccountHolderName("divya");
		account.setAccountNumber(122425251);
		account.setBalance(14151);
	}
	@Test
	public void testCustomerHolderName() {

		Mockito.when(accountRepository.findByAccountHolderName(account.getAccountHolderName())).thenReturn(account);
		Account s1 = accountServiceImpl.findByAccountHolderName(account.getAccountHolderName());
		Assert.assertEquals("divya", s1.getAccountHolderName());

	}
	@Test(expected = AccountNotFoundException.class)
	public void testStudentByNameForException() {

		Mockito.when(accountRepository.findByAccountHolderName(account.getAccountHolderName())).thenReturn(account);
		accountServiceImpl.findByAccountHolderName("divya1");

	}
	@Test

	public void testCustomerId() {
		Mockito.when(accountRepository.getOne(account.getAccountNumber())).thenReturn(account);
		Account c1 =  accountServiceImpl.findAccountById(account.getAccountNumber());
		Assert.assertEquals(122425251, c1.getAccountNumber());
	}
	@Test
	public void testForAllBeneficariry() {
		Mockito.when(accountRepository.getOne(account.getAccountNumber())).thenReturn(account);
		Set<Beneficiary> c1 = accountServiceImpl.getallBeneficiariesByNo(account.getAccountNumber());
		Assert.assertNull(c1);
		
	
	}
	@AfterClass
	public static void tearDown() {
		account= null;
	}
}

