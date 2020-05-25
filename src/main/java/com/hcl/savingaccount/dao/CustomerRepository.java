package com.hcl.savingaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByAadhar(String aadhar);
	public Customer getCustomerByAccount(Account account);
}
