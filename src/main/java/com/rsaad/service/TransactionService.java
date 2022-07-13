package com.rsaad.service;

import java.util.List;
import java.util.Optional;

import com.rsaad.dto.TransactionDto;

public interface TransactionService {
	
	/**
	 * returns all the transactions linked to a specific customer
	 * @param customerId
	 * @return
	 */
	public Optional<List<TransactionDto>> customerTransactions(String customerId);
	public TransactionDto createNewTransaction(TransactionDto transactionDto);
	public TransactionDto updateTransaction(TransactionDto transactionDto);
	public void deleteTransaction(String id);
	public Optional<TransactionDto> findTransactionById(String id);
	public List<TransactionDto> findAllTransactions();
}
