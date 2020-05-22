package com.hcl.hackathon.savingsaccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.savingsaccount.model.Customer;
import com.hcl.hackathon.savingsaccount.service.CustomerService;


@RestController
public class CustomerController {
	@Autowired
	 CustomerService  customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer customer1=customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
	@GetMapping("/customer1/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@DeleteMapping("/customer2/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("customer is  deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
}
