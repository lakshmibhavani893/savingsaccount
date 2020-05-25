package com.hcl.savingaccount.service;

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

import com.hcl.savingaccount.dao.CustomerRepository;
import com.hcl.savingaccount.exception.InvalidNameException;
import com.hcl.savingaccount.model.Customer;
@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
@InjectMocks
	CustomerServiceImpl  customerServiceImpl;
@Mock
CustomerRepository customerRepository;
static Customer customer=null;
@BeforeClass
public static void setUp() {
	customer = new Customer();

}
@Before
public void beforeMethod(){
	customer.setCustomerId(1l);
	customer.setFirstName("sowjanya");
	customer.setLastName("bana");
	customer.setEmail("sowji@gmail.com");
	customer.setPassword(12344);
	customer.setOccupation("software");
	customer.setAadhar("535657874");
	customer.setPAN("63jgh558hgku");
	customer.setAddress("Anantapur");
	customer.setPinCode("515411");

}

@Test
public void testupdateCustomer() {
	Mockito.when(customerRepository.saveAndFlush(customer)).thenReturn(customer);
	Customer s1 = customerServiceImpl.updateCustomerDetails(customer);
	Assert.assertNotEquals("divya1", s1.getFirstName());
}
@Test
public void testCustomerBtAadhar() {

	Mockito.when(customerRepository.findByAadhar(customer.getAadhar())).thenReturn(customer);
	Customer s1 = customerServiceImpl.findCustomerByAadhar(customer.getAadhar());
	Assert.assertEquals("535657874", s1.getAadhar());

}

@Test(expected = InvalidNameException.class)
public void testupdateStudentForException() {

	customer.setFirstName("bhavai&");

	Mockito.when(customerRepository.saveAndFlush(customer)).thenReturn(customer);
	customerServiceImpl.updateCustomerDetails(customer);

}

@Test
public void testCustomerById() {

	Mockito.when(customerRepository.getCustomerByAccount(customer.getAccount())).thenReturn(customer);
	Customer s1 = customerServiceImpl.getAccountByCustomerId(customer.getAccount());
	Assert.assertNotNull(s1);

}
@Test
public void testCustomerLogin() {

	Mockito.when(customerRepository.getOne(customer.getCustomerId())).thenReturn(customer);
 Object s1=customerServiceImpl.login(customer);
	Assert.assertNotNull(s1);

}
@AfterClass
public static void tearDown() {
	customer= null;
}

}

