package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.nit.*")

public class HdfcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdfcApplication.class, args);
	}

}
