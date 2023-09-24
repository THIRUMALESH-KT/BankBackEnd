package com.nit.service;

import org.springframework.stereotype.Service;

import com.nit.Entity.Customer;

public interface CustomerService {

	Long save(Customer customer);
	Customer getOneCustomer(Long id);
	String UpdateCustomer(Customer customer);
	Customer getByMobile(Long mobile);
}
