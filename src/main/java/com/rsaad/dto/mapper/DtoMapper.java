package com.rsaad.dto.mapper;

import com.rsaad.dto.AccountDto;
import com.rsaad.dto.CustomerDto;
import com.rsaad.dto.TransactionDto;
import com.rsaad.model.Account;
import com.rsaad.model.Customer;
import com.rsaad.model.Transaction;

public class DtoMapper { 
	
	/**
	 * converts customer object to customerDTO
	 * @param sourceCustomer
	 * @return
	 */
	public static CustomerDto toCustomerDto(Customer sourceCustomer) {
		return CustomerDto.builder().customerId(sourceCustomer.getId())
				.name(sourceCustomer.getName())
				.surName(sourceCustomer.getSurName())
				.dateCreated(sourceCustomer.getDateCreated())
				.dateUpdated(sourceCustomer.getDateUpdated())
				.build();
	}
	
	/**
	 * converts transaction object to transactionDto
	 * @param sourceTransaction
	 * @return
	 */
	public static TransactionDto toTransactionDto(Transaction sourceTransaction) {
		return TransactionDto.builder().transactionId(sourceTransaction.getId())
				.amount(sourceTransaction.getAmount())
				.currency(sourceTransaction.getCurrency())
				.fromAccount(sourceTransaction.getFromAccount())
				.toAccount(sourceTransaction.getToAccount())
				.transactionDate(sourceTransaction.getTransactionDate())
				.transactionType(sourceTransaction.getTransactionType())
				.dateCreated(sourceTransaction.getDateCreated())
				.dateUpdated(sourceTransaction.getDateUpdated())
				.accountId(sourceTransaction.getAccountId())
				.build();
	}
	
	/**
	 * converts account object to accountDto
	 * @param sourceAccount
	 * @return
	 */
	public static AccountDto toAccountDto(Account sourceAccount) {
		return  AccountDto.builder()
				.balanace(sourceAccount.getBalanace()).dateCreated(sourceAccount.getDateCreated())
				.dateCreated(sourceAccount.getDateCreated())
				.dateUpdated(sourceAccount.getDateUpdated())
				.customerId(sourceAccount.getCustomerId())
				.accountId(sourceAccount.getId())
				.build();
	}
	
	/**
	 * converts customerDto object to customer
	 * @param sourceCustomerDto
	 * @return
	 */
	public static Customer toCustomer(CustomerDto sourceCustomerDto) {
		return Customer.builder().name(sourceCustomerDto.getName())
			.surName(sourceCustomerDto.getSurName())
			.dateCreated(sourceCustomerDto.getDateCreated())
			.dateUpdated(sourceCustomerDto.getDateUpdated())
			.build();
	}
	
	/**
	 * converts transactionDto to transaction
	 * @param sourceTransactionDto
	 * @return
	 */
	public static Transaction toTransaction(TransactionDto sourceTransactionDto) {
		return Transaction.builder()
				.id(sourceTransactionDto.getTransactionId())
				.amount(sourceTransactionDto.getAmount())
				.currency(sourceTransactionDto.getCurrency())
				.fromAccount(sourceTransactionDto.getFromAccount())
				.toAccount(sourceTransactionDto.getToAccount())
				.transactionDate(sourceTransactionDto.getTransactionDate())
				.transactionType(sourceTransactionDto.getTransactionType())
				.dateCreated(sourceTransactionDto.getDateCreated())
				.dateUpdated(sourceTransactionDto.getDateUpdated())
				.accountId(sourceTransactionDto.getAccountId())
				.build();
	}
	
	/**
	 * converts accountDto to account
	 * @param sourceAccountDto
	 * @return
	 */
	public static Account toAccount(AccountDto sourceAccountDto) {
		return  Account.builder()
				.id(sourceAccountDto.getAccountId())
				.balanace(sourceAccountDto.getBalanace()).dateCreated(sourceAccountDto.getDateCreated())
				.customerId(sourceAccountDto.getCustomerId())
				.dateCreated(sourceAccountDto.getDateCreated())
				.dateUpdated(sourceAccountDto.getDateUpdated())
				.build();
	}	

}
