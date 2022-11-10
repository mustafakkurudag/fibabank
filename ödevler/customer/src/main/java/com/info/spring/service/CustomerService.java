package com.info.spring.service;

import java.util.List;

import com.info.spring.Customer;

public interface CustomerService {
	Customer find(long customerId);
	
	List<Customer> findAll();
	
	void createCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(long customerId);
	
}
