package com.hcl.savingaccount.service;

import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;

public interface CustomerService {
	
	public Customer registration(Customer customer);
	public Customer updateCustomerDetails(Customer customer);
	public Customer findCustomerByAadhar(String aadhar);
	public Customer getAccountByCustomerId(Account account);
	public Object login(Customer customer);

}
