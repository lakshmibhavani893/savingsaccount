package com.hcl.savingaccount.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.savingaccount.model.Beneficiary;


public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

	public Beneficiary findByName(String name);
	public Optional<Beneficiary> findByBeneficiaryAccountNumber(long number);
	
}
