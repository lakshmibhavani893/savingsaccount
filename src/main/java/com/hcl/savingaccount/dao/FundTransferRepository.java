package com.hcl.savingaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.savingaccount.model.Transfer;


public interface FundTransferRepository extends JpaRepository<Transfer, Integer>{

}
