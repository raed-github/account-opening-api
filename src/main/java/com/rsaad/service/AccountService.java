package com.rsaad.service;

import java.util.List;
import java.util.Optional;

import com.rsaad.dto.AccountDto;
import com.rsaad.dto.OpenAccountDto;


public interface AccountService {

	/**
	 * creates an account for a given customer
	 * @param openAccountDto
	 * @return
	 */
	public Optional<AccountDto> openAccount(OpenAccountDto openAccountDto);

	/**
	 * fetch accounts related to a particular customer
	 * @param customerId
	 * @return
	 */
	public Optional<List<String>> findCustomerAccounts(String customerId);
	public AccountDto createNewAccount(AccountDto accountDto);
	public AccountDto updateAccount(AccountDto accountDto);
	public void deleteAccount(String id);
	public Optional<AccountDto> findAccountById(String id);
	public List<AccountDto> findAllAccounts();
	
}
