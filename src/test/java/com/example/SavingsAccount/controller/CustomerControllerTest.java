package com.example.SavingsAccount.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.hackathon.savingsaccount.controller.CustomerController;
import com.hcl.hackathon.savingsaccount.model.Customer;
import com.hcl.hackathon.savingsaccount.service.CustomerService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class CustomerControllerTest {
	@InjectMocks
	CustomerController customerController;
	@Mock
	CustomerService customerService;
	@Test
	public void testSaveCustomerForPositive() {
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setFirstName("sowjanya");
		customer.setLastName("bana");
		customer.setEmail("sowji@gmail.com");
		customer.setPassword("sowjanya");
		customer.setOccupation("software");
		customer.setAadhar("535657874");
		customer.setPAN("63jgh558hgku");
		customer.setAddress("Anantapur");
		customer.setPinCode("515411");
		
		Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn((customer));
		ResponseEntity<Customer> resStudent =customerController.saveCustomer(customer);
		Assert.assertNotNull(resStudent);
		Assert.assertEquals(customer.getFirstName(), "sowjanya");
	}
	@Test
	public void testSaveCustomerForNegative() {
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setFirstName("sowjanya");
		customer.setLastName("bana");
		customer.setEmail("sowji@gmail.com");
		customer.setPassword("sowjanya");
		customer.setOccupation("software");
		customer.setAadhar("535657874");
		customer.setPAN("63jgh558hgku");
		customer.setAddress("Anantapur");
		customer.setPinCode("Anantapur");
		Customer customer1 = new Customer();
		customer1.setCustomerId(1l);
		customer1.setFirstName("sowjanya");
		customer1.setLastName("bana");
		customer1.setEmail("sowji@gmail.com");
		customer1.setPassword("sowjanya");
		customer1.setOccupation("software");
		customer1.setAadhar("535657874");
		Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn((customer));
		ResponseEntity<Customer> resStudent =customerController.saveCustomer(customer1);
		Assert.assertNotNull(resStudent);
		Assert.assertEquals(customer.getFirstName(), "sowjanya");
	}
	@Test
	public void testGetALLCustomersForPosite() {
		List<Customer> customers = new ArrayList(); 
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setFirstName("sowjanya"); 
		
		customer.setLastName("bana");
		customer.setEmail("sowji@gmail.com");
		customer.setPassword("sowjanya");
		customer.setOccupation("software");
		customer.setAadhar("535657874");
		customer.setPAN("63jgh558hgku");
		customer.setAddress("Anantapur");
		customer.setPinCode("515411");
		Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn((customer));
		ResponseEntity<Customer> resStudent =customerController.saveCustomer(customer);
		Assert.assertNotNull(resStudent);
		Assert.assertEquals(customer.getFirstName(), "sowjanya");
	}
	@Test
	public void testGetALLCustomersForNegative() {
		List<Customer> customers = new ArrayList(); 
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setFirstName("sowjanya");
		customer.setLastName("bana");
		customer.setEmail("sowji@gmail.com");
		customer.setPassword("sowjanya");
		customer.setOccupation("software");
		customer.setAadhar("535657874");
		customer.setPAN("63jgh558hgku");
		customer.setAddress("Anantapur");
		customer.setPinCode("515411");
		Customer customer1 = new Customer();
		customer1.setCustomerId(1l);
		customer1.setFirstName("sowjanya");
		customer1.setLastName("bana");
		customer1.setEmail("sowji@gmail.com");
		customer1.setPassword("sowjanya");
		customer1.setOccupation("software");
		customer1.setAadhar("535657874");

		Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn((customer));
		ResponseEntity<Customer> resCustomer =customerController.saveCustomer(customer1);
		Assert.assertNotNull(resCustomer);
		Assert.assertEquals(customer.getFirstName(), "sowjanya");
	}
	@Test(expected = NullPointerException.class)
	public void testGetAllCustomersForExc() {
		Mockito.when(customerService.getAllCustomers()).thenThrow(NullPointerException.class);
		List<Customer> resCustomers = (List<Customer>) customerController.getAllCustomers();

	}
	}


