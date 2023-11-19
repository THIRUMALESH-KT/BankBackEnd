package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Entity.Address;
import com.nit.Entity.Customer;
import com.nit.service.*;
@RestController
public class HDFCMain {

	@Autowired
	private CustomerService service;
	@GetMapping("/hello")
	public ResponseEntity<Object> main() {
		return new ResponseEntity<Object>("hello page",HttpStatus.OK);
		//
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Customer customer) {
		
		service.save(customer);
		return "Your Account Number: "+customer.getAccountNumber()+"  Please note it";
	}
	
//	get details using account number and customer name
	
	@GetMapping("/login/{accountNumber}/{custName}")
	public ResponseEntity<Object> CustomerLogin(@PathVariable Long accountNumber, @PathVariable String custName) {
		Customer cust=service.getOneCustomer(accountNumber);
		if(cust!=null) {
		if((cust.getFName()+" "+cust.getLName()).equals(custName)) {
			System.out.println("correct");
			return new ResponseEntity<Object>(cust,HttpStatus.OK);
		}
		else {
	        System.out.println("wrong");
	        return new ResponseEntity<Object>("account number or customer name is wrong ",HttpStatus.BAD_REQUEST);
	    }
		}
		else {
	        System.out.println("wrong");
	        return new ResponseEntity<Object>("account number or customer name is wrong",HttpStatus.BAD_REQUEST);
	    }
		
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer ) {
		
		return new ResponseEntity<Object>(service.UpdateCustomer(customer),HttpStatus.OK);
	}
	
	//get details using mobile number
	@GetMapping("/findByMobile/{mobileNumber}")
	public ResponseEntity<Object> getByMobile(@PathVariable Long mobileNumber){
		Customer cust=service.getByMobile(mobileNumber);
		if(cust!=null) {
			System.out.println("mobile number founded ");
			return new ResponseEntity<Object>(cust,HttpStatus.OK);
		}
		else {
			System.out.println("mobile number founded ");

			return new ResponseEntity<Object>("mobile number not found",HttpStatus.BAD_REQUEST);
		}
	}
}
