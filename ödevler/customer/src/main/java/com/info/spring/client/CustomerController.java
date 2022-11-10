package com.info.spring.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.info.spring.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId = 36;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		
		System.out.println("Gelen müşteri bilgileri: " + customer.getCustomerId() + 
				" - " + customer.getCustomerName() + " - " + customer.getTotalDebit());
		
		return "Gelen müşteri bilgileri: " + customer.getCustomerId() + 
				" - " + customer.getCustomerName() + " - " + customer.getTotalDebit();
	}
	
	@GetMapping("customer/getall")
	@ResponseBody
	public List<Customer> getAllCustomers() {
		String url = "http://localhost:8080/api/customer/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer[]> responseEntity = restTemplate.getForEntity(url, Customer[].class);
		List<Customer> customerList = Arrays.asList(responseEntity.getBody());
		
		System.out.println("\"Gelen müşteri bilgileri: ");
		for(Customer cust : customerList) {
			System.out.println(
					cust.getCustomerId() + 
					" - " + cust.getCustomerName() + 
					" - " + cust.getTotalDebit());
		}
		
		return customerList;
	}	
	
	@GetMapping("customer/post")
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(0, "Abdullah Avcı", 50500);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer cust = restTemplate.postForObject(url, customer, Customer.class);
		
		return "Müşteri bilgileri gönderildi - ID: " + cust.getCustomerId();
	}
	
	@GetMapping("customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(40, "Şenol Güneş", 120200);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url,HttpMethod.PUT, new HttpEntity<Customer>(customer), Void.class);
		
		return "Müşteri bilgileri güncellendi - ID: " + customer.getCustomerId();
	}
	
	@GetMapping("customer/delete")
	@ResponseBody
	public String deleteCustomer() {
		long customerId = 32;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		
		return customerId + " ID'li kayıt silindi";
	}
	
}
