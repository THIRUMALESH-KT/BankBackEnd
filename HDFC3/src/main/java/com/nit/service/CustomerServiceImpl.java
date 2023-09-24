package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Entity.Customer;
import com.nit.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public Long save(Customer customer) {
		// TODO Auto-generated method stub
		
		return repo.save(customer).getAccountNumber();
	}

	@Override
	public Customer getOneCustomer(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public String UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repo.save(customer);
		return "your Operation is sucefully completed" ;
	}

	@Override
	public Customer getByMobile(Long mobile) {
		// TODO Auto-generated method stub
		return repo.findByMobile(mobile);
	}

}
