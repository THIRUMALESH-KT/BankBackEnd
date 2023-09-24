package com.nit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	    @SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1, initialValue = (int) 100000000000L)
	
	private Long accountNumber;
	private String drNo;
	private String village;
	private String mondal;
	private String district;
	private String state;
	private Integer pincode;

}
