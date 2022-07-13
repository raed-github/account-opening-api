package com.rsaad.service;

import java.util.List;
import java.util.Optional;

import com.rsaad.dto.CustomerDto;
import com.rsaad.dto.CustomerInfoDto;

public interface CustomerService {
	
	/**
	 * return customer information
	 * @param customerId
	 * @return
	 */
	public Optional<CustomerInfoDto> getCustomerInfo(String customerId);
	public CustomerDto createNewCustomer(CustomerDto customerDto);
	public CustomerDto updateCustomer(CustomerDto customerDto);
	public void deleteCustomer(String id);
	public Optional<CustomerDto> findCustomerById(String id);
	public List<CustomerDto> findAllCustomers();
}
