package com.hcl.savingaccount.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountControllerTest {
	@InjectMocks
	AccountController accountController;
	@Mock
	AccountServiceImpl accountServiceImpl;

	static Account account= null;

	@BeforeClass
	public static void setUp() {
		account = new Account();

	}
	@Before
	public void beforeMethod() {

		account.setAccountHolderName("divya");
		account.setAccountNumber(123336636);
		account.setBalance(23456);
	}
	@Test
	public void testAccuntById() {
		
		Mockito.when(accountServiceImpl.findAccountById(account.getAccountNumber())).thenReturn(account);
		ResponseEntity<Account> s1=accountController.getAccountById(account.getAccountNumber());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@Test
	public void testAccuntByName() {
		
		Mockito.when(accountServiceImpl.findByAccountHolderName(account.getAccountHolderName())).thenReturn(account);
		ResponseEntity<Account> s1=accountController.getAccountByName(account.getAccountHolderName());
		Assert.assertEquals(HttpStatus.OK, s1.getStatusCode());
		
	}
	@AfterClass
	public static void tearDown() {
		account= null;
	}

}
