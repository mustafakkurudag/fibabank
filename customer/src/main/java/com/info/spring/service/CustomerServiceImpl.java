package com.info.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.info.spring.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId, "Erdal Bakkal", 15000);
		
		System.out.println("Müşteri kaydı bulundu: " + customer.getCustomerId() + 
				" " + customer.getCustomerName() + " " + customer.getTotalDebit());
		
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(30, "Örnek Kırtasiye", 4000));
		customerList.add(new Customer(31, "Yarım Ekmek Döner A.Ş.", 9600));
		
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(32);
		
		System.out.println("Müşteri eklendi: " + customer.getCustomerId() + 
				" - " + customer.getCustomerName() + " - " + customer.getTotalDebit());
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Müşteri güncellendi: " + customer.getCustomerId() + 
				" - " + customer.getCustomerName() + " - " + customer.getTotalDebit());
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Müşteri kaydı silindi: " + customerId);		
	}

}
