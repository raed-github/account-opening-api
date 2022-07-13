package com.rsaad.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsaad.dto.TransactionDto;
import com.rsaad.dto.mapper.DtoMapper;
import com.rsaad.exception.TransactionNotFoundException;
import com.rsaad.model.Transaction;
import com.rsaad.repository.TransactionRepository;
import com.rsaad.service.AccountService;
import com.rsaad.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;	
	@Autowired
	private AccountService accountService;

	@Override
	public Optional<List<TransactionDto>> customerTransactions(String customerId) {
		List<Transaction> customerTransactions = new ArrayList();
		try {
			Optional<List<String>> customerAccounts = accountService.findCustomerAccounts(customerId);
			List<String> trxList = customerAccounts.filter(Predicate.not(List::isEmpty)).get();
			for(String str : trxList) {
				customerTransactions.addAll(transactionRepository.findTransactionByAccountId(str));
			}							
		} catch (Exception e) { 
			return Optional.empty();
		}
	    return Optional.of(customerTransactions.stream().map(DtoMapper::toTransactionDto).collect(Collectors.toList()));
	}

	@Override
	public TransactionDto createNewTransaction(TransactionDto transactionDto) {
		Transaction transaction = transactionRepository.save(DtoMapper.toTransaction(transactionDto));
		return DtoMapper.toTransactionDto(transaction);
	}

	@Override
	public TransactionDto updateTransaction(TransactionDto transactionDto) {
		Transaction transaction = transactionRepository.save(DtoMapper.toTransaction(transactionDto));
		return DtoMapper.toTransactionDto(transaction);
	}

	@Override
	public void deleteTransaction(String id) {
		Transaction transaction = Transaction.builder().id(id).build();
		transactionRepository.delete(transaction);		
	}

	@Override
	public Optional<TransactionDto> findTransactionById(String id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		if(transaction.isPresent()) {
			return Optional.of(DtoMapper.toTransactionDto(transaction.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<TransactionDto> findAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transactions.stream()
				.map(DtoMapper::toTransactionDto)
				.collect(Collectors.toList());
	}

	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}

	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

}
