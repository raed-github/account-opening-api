package com.rsaad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsaad.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{

}
