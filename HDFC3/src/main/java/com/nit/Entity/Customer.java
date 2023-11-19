package com.nit.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	 @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize =1, initialValue = (int) 100000000000L)
	private Long accountNumber;
	private String bankName="HDFC";
	private String iFSCcode="HDFC00001";
	private String fName;
	private String lName;
	private Long custMobile;
	private Float balance;
	private Integer atmpin=0000;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "accountNumber")
	@MapsId
	private Address address;
	
	
}
