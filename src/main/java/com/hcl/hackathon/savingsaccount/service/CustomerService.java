package com.hcl.hackathon.savingsaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.hackathon.savingsaccount.exceptions.CustomerNotFoundException;
import com.hcl.hackathon.savingsaccount.exceptions.NullCustomerDataFoundException;
import com.hcl.hackathon.savingsaccount.model.Customer;
import com.hcl.hackathon.savingsaccount.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		if (customer != null) {

			return customerRepository.save(customer);
		} else {
			throw new NullCustomerDataFoundException();
		}
	}

	public Customer getCustomer(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
		return customer.get();
		}
		else {
			 throw new CustomerNotFoundException();
		}
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> students = customerRepository.findAll();
		if (students.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		return students;
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
