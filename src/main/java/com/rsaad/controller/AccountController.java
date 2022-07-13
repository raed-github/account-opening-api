package com.rsaad.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

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

import com.rsaad.constants.AccountConstants;
import com.rsaad.dto.AccountDto;
import com.rsaad.dto.OpenAccountDto;
import com.rsaad.exception.CustomerNotFoundException;
import com.rsaad.service.AccountService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/accounts/open-account")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AccountDto> openAccount(@Valid @RequestBody OpenAccountDto openAccountDto) {
		return accountService.openAccount(openAccountDto)
				.map(ResponseEntity::ok)
		.orElseThrow(CustomerNotFoundException::new);
	}
	 
    @GetMapping("/accounts/customer-accounts/{id}")
    public ResponseEntity<List<String>> findCustomerAccounts(@PathVariable("id") String id) throws AccountNotFoundException {
		return accountService.findCustomerAccounts(id)
				.map(ResponseEntity::ok)
				.orElseThrow(AccountNotFoundException::new);
    }
    
    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") String id, @RequestBody AccountDto accountDto) {
		return accountService.findAccountById(id)
    			.map(savedAccountDto->{
    				
    				savedAccountDto.setBalanace(accountDto.getBalanace());
    				savedAccountDto.setDateUpdated(null);
    				savedAccountDto.setCustomerId(accountDto.getCustomerId());
    				
    			    AccountDto updatedAccount = accountService.updateAccount(savedAccountDto);
    				return new ResponseEntity<>(updatedAccount,HttpStatus.OK);
    			}).orElseGet(()->ResponseEntity.notFound().build());
    }
    
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable("id") String id) {
		return accountService.findAccountById(id)
				.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
    	accountService.deleteAccount(id);
        return new ResponseEntity<String>(AccountConstants.ACCOUNT_DELETED, HttpStatus.OK);
    }

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}