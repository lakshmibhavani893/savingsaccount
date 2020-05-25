package com.hcl.savingaccount.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.savingaccount.dao.CustomerRepository;
import com.hcl.savingaccount.exception.CustomerNotFoundException;
import com.hcl.savingaccount.exception.InvalidDateOfBirthException;
import com.hcl.savingaccount.exception.InvalidNameException;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registration(Customer customer) throws InvalidNameException {
		Date date = java.util.Calendar.getInstance().getTime();
		if ((customer.getDateOfBirth().before(date))) {
			return customerRepository.saveAndFlush(customer);
		}
		throw new InvalidDateOfBirthException();
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		if ((customer.getFirstName() != null) && (customer.getFirstName().chars().allMatch(Character::isLetter))) {
			return customerRepository.saveAndFlush(customer);
		}
		throw new InvalidNameException();
	}

	@Override
	public Customer findCustomerByAadhar(String aadhar) {
		return customerRepository.findByAadhar(aadhar);
	}

	@Override
	public Customer getAccountByCustomerId(Account account) {
		return customerRepository.getCustomerByAccount(account);
	}

	@Override
	public Object login(Customer customer) {
		Customer customer1 = customerRepository.getOne(customer.getCustomerId());
		if ((customer1.getCustomerId() == customer.getCustomerId())
				&& (customer1.getPassword() == customer.getPassword())) {
			return "Login Successfully";
		}
		throw new CustomerNotFoundException();
	}

}
