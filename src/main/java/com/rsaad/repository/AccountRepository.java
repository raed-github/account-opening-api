package com.rsaad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsaad.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>{

	public List<Account> findAccountsByCustomerId(String customerId);
}
