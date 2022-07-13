package com.rsaad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsaad.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String>{
	public List<Transaction> findTransactionByAccountId(String accountId);

}
