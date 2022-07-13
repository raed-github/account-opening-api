package com.rsaad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsaad.constants.TransactionConstants;
import com.rsaad.dto.TransactionDto;
import com.rsaad.exception.TransactionNotFoundException;
import com.rsaad.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

    @GetMapping("/transactions/customer-transactions/{customerId}")
    public ResponseEntity<List<TransactionDto>> findCustomerTransactions(@PathVariable("customerId") String customeerId) {
    	return transactionService.customerTransactions(customeerId).map(ResponseEntity::ok)
    			.orElseThrow(TransactionNotFoundException::new);
    }

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
	public void createTransaction(@RequestBody TransactionDto transactionDto) {
    	transactionDto.setDateCreated(null);
    	transactionService.createNewTransaction(transactionDto);
	}
        
    @PutMapping("/transactions/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable("id") String id, @RequestBody TransactionDto transactionDto) {
		return transactionService.findTransactionById(id)
    			.map(savedTransactionDto->{
    				savedTransactionDto.setAmount(transactionDto.getAmount());
    				savedTransactionDto.setCurrency(transactionDto.getCurrency());
    				savedTransactionDto.setDateUpdated(null);
    				savedTransactionDto.setFromAccount(transactionDto.getFromAccount());
    				savedTransactionDto.setToAccount(transactionDto.getToAccount());
    				savedTransactionDto.setTransactionDate(transactionDto.getTransactionDate());
    				savedTransactionDto.setTransactionType(transactionDto.getTransactionDate());
    				TransactionDto updatedTransactionDto = transactionService.updateTransaction(savedTransactionDto);
    				return new ResponseEntity<>(updatedTransactionDto,HttpStatus.OK);
    			}).orElseGet(()->ResponseEntity.notFound().build());
    }
    
    @GetMapping("/transactions/{id}")
    public ResponseEntity<TransactionDto> findTransactionById(@PathVariable("id") String id) {
		return transactionService.findTransactionById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(TransactionNotFoundException::new);
    }
    
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) {
    	transactionService.deleteTransaction(id);
        return new ResponseEntity<String>(TransactionConstants.TRANSACTION_DELETED, HttpStatus.OK);
    }

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

}
