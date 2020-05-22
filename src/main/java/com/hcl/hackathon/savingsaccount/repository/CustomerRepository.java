package com.hcl.hackathon.savingsaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.hcl.hackathon.savingsaccount.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>  {

	
}
